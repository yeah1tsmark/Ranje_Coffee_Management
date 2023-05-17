package com.example.ranjecoffeemanagement

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var ivnote:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        ivnote = findViewById(R.id.iv_note)

        ivnote.alpha = 0f
        ivnote.animate().setDuration(1500).alpha(1f).withEndAction {
            var gotomain = Intent(this,LoginActivity::class.java)
            startActivity(gotomain)

            finish()
        }
    }
}