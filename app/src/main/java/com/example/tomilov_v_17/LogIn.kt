package com.example.tomilov_v_17

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.access_manager)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener {
            // Переход с 1 экрана на 2 (LogIn -> PersonalArea)
            val intent = Intent(this, PersonalArea::class.java)
            startActivity(intent)
            finish()
        }
    }
}
