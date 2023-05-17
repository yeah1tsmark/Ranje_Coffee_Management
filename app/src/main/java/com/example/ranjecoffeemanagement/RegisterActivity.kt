package com.example.ranjecoffeemanagement

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {
    var backPressedTime:Long = 0

    lateinit var textheadingreg: TextView
    lateinit var editregname:EditText
    lateinit var editregemail:EditText
    lateinit var editregpass:EditText
    lateinit var buttoncreateuser:Button
    lateinit var buttongotologin:Button

    lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        editregname = findViewById(R.id.edtregname)
        editregemail = findViewById(R.id.edtregemail)
        editregpass = findViewById(R.id.edtregpass)
        buttoncreateuser = findViewById(R.id.btncreateuser)
        buttongotologin = findViewById(R.id.btngotologin)

        auth = FirebaseAuth.getInstance()

        buttongotologin.setOnClickListener{
            var gotologin = Intent(this, LoginActivity::class.java)
            startActivity(gotologin)
        }


        buttoncreateuser.setOnClickListener{
            var name = editregname.text.toString().trim()
            var email =  editregemail.text.toString().trim()
            var pass = editregpass.text.toString().trim()

            // VALIDATION*
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "Error! Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()

                        finish()

                    }else{
                        Toast.makeText(this, "Failed to create user", Toast.LENGTH_SHORT).show()
                    }
                }


            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (backPressedTime + 3000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(this, "Press back again to exit the app", Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    }













