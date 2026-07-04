package com.example.tomilov_v_17

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PersonalArea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val ivSettings = findViewById<ImageView>(R.id.iv_settings)
        val btnExit = findViewById<LinearLayout>(R.id.btn_exit)
        val tvHello = findViewById<TextView>(R.id.tv_hello)
        val btnOnline = findViewById<LinearLayout>(R.id.btn_online)

        // Получаем имя пользователя из Intent (по заданию)
        val username = intent.getStringExtra("username") ?: "Гость"
        val fullText = getString(R.string.hello, username)
        val spannable = android.text.SpannableString(fullText)
        val startIndex = fullText.indexOf(username)
        if (startIndex != -1) {
            val color = androidx.core.content.ContextCompat.getColor(this, R.color.yellow_main)
            spannable.setSpan(android.text.style.ForegroundColorSpan(color), startIndex, startIndex + username.length, android.text.Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        tvHello.text = spannable

        // Открытие браузера по кнопке Онлайн
        btnOnline.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse("https://fazenda.shop"))
            startActivity(browserIntent)
        }

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
