package com.example.ranjecoffeemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewData : AppCompatActivity() {

    lateinit var mylistview:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)

        mylistview = findViewById(R.id.ListData)

        var blockdata:ArrayList<Block> = ArrayList()

        var myadapter = CustomAdapter(applicationContext, blockdata)

        var mydb = FirebaseDatabase.getInstance().reference.child("Data")
        mydb.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                //get data and display in array
                blockdata.clear()
                for (snap in snapshot.children){
                    var person = snap.getValue(Block::class.java)
                    blockdata.add(person!!)
                }

                myadapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Failed to Display Data", Toast.LENGTH_SHORT).show()

            }

        })
        mylistview.adapter = myadapter
    }

}
