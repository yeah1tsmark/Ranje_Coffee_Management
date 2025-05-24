package com.example.ranjecoffeemanagement

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var backPressedTime:Long = 0

    lateinit var rbuttonranjemain: RadioButton
    lateinit var rbuttonranjeannex: RadioButton
    lateinit var rbuttonsangalo: RadioButton
    lateinit var rbuttonbuema: RadioButton
    lateinit var rbuttonnangeni: RadioButton
    lateinit var rgroupblocks:RadioGroup
    lateinit var textblock: TextView
    lateinit var gotoview:TextView


    lateinit var textheadinghome:EditText
    lateinit var buttontodatainput:Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbuttonranjemain = findViewById(R.id.rbtnranjemain)
        rbuttonranjeannex = findViewById(R.id.rbtnranjeannex)
        rbuttonsangalo = findViewById(R.id.rbtnsangalo)
        rbuttonbuema = findViewById(R.id.rbtnbuema)
        rbuttonnangeni = findViewById(R.id.rbtnnangeni)
        rgroupblocks = findViewById(R.id.rgblocks)
        buttontodatainput = findViewById(R.id.btngotodatainput)
        textblock = findViewById(R.id.txtblock)
        gotoview = findViewById(R.id.btngotoviewdata)

        buttontodatainput.setOnClickListener{
            val selectedBlock = textblock.text.toString()
            var gotodatainput = Intent(this, DataInputActivity::class.java)
            gotodatainput.putExtra("BLOCK_NAME", selectedBlock)
            startActivity(gotodatainput)
        }

        gotoview.setOnClickListener {
            var gotoview = Intent(this, ViewData::class.java)
            startActivity(gotoview)
        }

        rbuttonranjemain.setOnClickListener {
            textblock.text = "Block A"
        }
        rbuttonranjeannex.setOnClickListener {
            textblock.text = "Block B"
        }

        rbuttonsangalo.setOnClickListener {
            textblock.text = "Block C"
        }

        rbuttonbuema.setOnClickListener {
            textblock.text = "Block D"
        }

        rbuttonnangeni.setOnClickListener {
            textblock.text = "Block E"
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()){
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, "Press back again to exit the app", Toast.LENGTH_SHORT).show()
            }
        backPressedTime = System.currentTimeMillis()


    }
}