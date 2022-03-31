package com.example.charusatbookstore

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase

class userbookAdapter(var ctx: Activity, var arlist: ArrayList<bookModel>): RecyclerView.Adapter<userbookAdapter.viewholder>() {
    val database = FirebaseDatabase.getInstance()
    //private var bid:String?=null
    private var bstatus:String?=null

    inner class viewholder(v: View):RecyclerView.ViewHolder(v){
        var book_name : TextView = v.findViewById(R.id.ubookname)
        var book_price : TextView = v.findViewById(R.id.ubookprice)
        var sold : Button=v.findViewById(R.id.booksold)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val v=ctx.layoutInflater.inflate(R.layout.userbooks_view,parent,false)
        return  viewholder(v)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.book_name.text=arlist[position].discription
        holder.book_price.text=arlist[position].price+"₹"

        var book=arlist[position]

        holder.itemView.setOnClickListener{
            var int1=Intent(ctx,book_details::class.java)
            int1.putExtra("bid",arlist[position].bookid.toString())
            int1.putExtra("bname",arlist[position].discription.toString())
            int1.putExtra("price",arlist[position].price.toString())
            int1.putExtra("userid",arlist[position].uid.toString())
            int1.putExtra("sub",arlist[position].subject.toString())
            int1.putExtra("flag","1")
            ctx.startActivity(int1)
        }
        if(arlist[position].status=="sold"){
            holder.sold.isEnabled=false
        }
        else
        {
            holder.sold.isEnabled=true
        }
        book.status="sold"

        holder.sold.setOnClickListener {
            book.status="sold"
            val builder = AlertDialog.Builder(ctx)
            builder.setTitle("SOLD")
            builder.setMessage("Are you sure about selling this book?")
            builder.setPositiveButton("Yes",{ dialogInterface : DialogInterface, i : Int ->
                val myref=database.getReference("Book")
                myref.child(arlist[position].bookid.toString()).setValue(book)
                })
            builder.setNegativeButton("No",{ dialogInterface : DialogInterface, i: Int ->})
            builder.show()
        }
    }

    override fun getItemCount(): Int {
        return arlist.size
    }

}