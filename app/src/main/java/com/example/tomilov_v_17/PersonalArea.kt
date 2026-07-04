package com.example.tomilov_v_17

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class PersonalArea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val ivSettings = findViewById<ImageView>(R.id.iv_settings)
        val btnExit = findViewById<LinearLayout>(R.id.btn_exit)

        // Переход со 2 экрана на 3 (PersonalArea -> Setting)
        ivSettings.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }

        // Переход со 2 экрана на 1 (PersonalArea -> LogIn)
        btnExit.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            finish()
        }
    }
}
