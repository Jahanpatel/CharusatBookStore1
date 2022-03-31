package com.example.charusatbookstore

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class sem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sem)

        val department = intent.getStringExtra("department")
        val college = intent.getStringExtra("college")
        val iv1 = findViewById<ImageView>(R.id.sem1)
        iv1.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 1")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }
        val iv2 = findViewById<ImageView>(R.id.sem2)
        iv2.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 2")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }
        val iv3 = findViewById<ImageView>(R.id.sem3)
        iv3.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 3")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }
        val iv4 = findViewById<ImageView>(R.id.sem4)
        iv4.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 4")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }

        val iv5 = findViewById<ImageView>(R.id.sem5)
        iv5.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 5")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }

        val iv6 = findViewById<ImageView>(R.id.sem6)
        iv6.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 6")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }

        val iv7 = findViewById<ImageView>(R.id.sem7)
        iv7.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 7")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }

        val iv8 = findViewById<ImageView>(R.id.sem8)
        iv8.setOnClickListener {
            val Intent = Intent(this, showbook::class.java)
            Intent.putExtra("sem", "SEM 8")
            Intent.putExtra("college", college)
            Intent.putExtra("department", department)
            startActivity(Intent)
        }
    }
        //otion menue
        override fun onCreateOptionsMenu (menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu,menu)
            return true
        }
        //option menue commands and next activity
        override fun onOptionsItemSelected(item: MenuItem):Boolean{
            return when(item.itemId){
                R.id.logout->{
                    FirebaseAuth.getInstance().signOut()
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("LOGOUT")
                    builder.setMessage("Do You want to logout from Applicatiom?")
                    builder.setPositiveButton("Yes",{ dialogInterface : DialogInterface, i : Int ->
                        finish()
                        startActivity(Intent(this, login::class.java))})
                    builder.setNegativeButton("No",{ dialogInterface : DialogInterface, i: Int ->})
                    builder.show()
                    true
                }
                R.id.edit->{
                    startActivity(Intent(this, Edit_profile::class.java))
                    true
                }
                R.id.ubook->{
                    startActivity(Intent(this,upload::class.java))
                    true
                }
                R.id.mybooks->{
                    startActivity(Intent(this,User_book::class.java))
                    true
                }
                else ->super.onOptionsItemSelected(item)

            }
    }
}