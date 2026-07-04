package com.example.tomilov_v_17

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_settings)

        val ivBack = findViewById<ImageView>(R.id.iv_back)
        val ivExit = findViewById<ImageView>(R.id.iv_exit)

        // Переход с 3 экрана на 2 (Setting -> PersonalArea)
        ivBack.setOnClickListener {
            val intent = Intent(this, PersonalArea::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        // Переход с 3 экрана на 1 (Setting -> LogIn)
        ivExit.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}
