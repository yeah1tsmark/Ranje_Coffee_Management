package com.example.ranjecoffeemanagement

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.ProgressBar

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var ivnote:ImageView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        ivnote = findViewById(R.id.iv_note)
        progressBar = findViewById(R.id.progressBar)

        // Fade in the image
        ivnote.alpha = 0f
        ivnote.animate().setDuration(1500).alpha(1f).start()

        // Animate the progress bar over 3.5 seconds (3500ms)
        ObjectAnimator.ofInt(progressBar, "progress", 0, 100).apply {
            duration = 3500
            start()
        }

        Handler(Looper.getMainLooper()).postDelayed({

            val gotomain = Intent(this, LoginActivity::class.java)
            startActivity(gotomain)

            finish()
        },3500)


    }

}