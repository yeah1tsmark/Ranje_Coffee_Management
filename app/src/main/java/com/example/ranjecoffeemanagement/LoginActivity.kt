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

class LoginActivity : AppCompatActivity() {
    var backPressedTime:Long = 0

    lateinit var textheadinglogin:TextView
    lateinit var editloginemail:EditText
    lateinit var editloginpass:EditText
    lateinit var buttonlogin:Button
    lateinit var buttongotoreg:Button

    lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editloginemail = findViewById(R.id.edtloginemail)
        editloginpass = findViewById(R.id.edtloginpass)
        buttonlogin = findViewById(R.id.btnlogin)
        buttongotoreg = findViewById(R.id.btngotoreg)

        auth = FirebaseAuth.getInstance()

        buttongotoreg.setOnClickListener {
            var gotoregister = Intent(this, RegisterActivity::class.java)
            startActivity(gotoregister)

        }

        buttonlogin.setOnClickListener {

            // verify
            var email = editloginemail.text.toString().trim()
            var pass = editloginpass.text.toString().trim()

            // VALIDATION
            if (email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "ERROR! Cannot submit an empty field", Toast.LENGTH_SHORT).show()

            }else{
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show()

                        var gotohome = Intent(this, MainActivity::class.java)
                        startActivity(gotohome)

                        finish()

                    }else{
                        Toast.makeText(this, "Failed to login!", Toast.LENGTH_SHORT).show()
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

















