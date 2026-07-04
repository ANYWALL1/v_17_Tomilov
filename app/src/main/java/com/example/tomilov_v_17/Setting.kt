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
        val cbOpt1 = findViewById<android.widget.CheckBox>(R.id.cb_opt1)
        val cbOpt2 = findViewById<android.widget.CheckBox>(R.id.cb_opt2)
        val cbOpt3 = findViewById<android.widget.CheckBox>(R.id.cb_opt3)
        val llNotification = findViewById<android.widget.LinearLayout>(R.id.ll_notification)
        val tvNotification = findViewById<android.widget.TextView>(R.id.tv_notification)

        fun updateNotification() {
            if (cbOpt1.isChecked && cbOpt2.isChecked && cbOpt3.isChecked) {
                llNotification.visibility = android.view.View.VISIBLE
                tvNotification.text = getString(R.string.location_enabled)
            } else if (!cbOpt1.isChecked && !cbOpt2.isChecked && !cbOpt3.isChecked) {
                llNotification.visibility = android.view.View.VISIBLE
                tvNotification.text = getString(R.string.location_disabled)
            } else {
                llNotification.visibility = android.view.View.GONE
            }
        }

        val listener = android.widget.CompoundButton.OnCheckedChangeListener { _, _ -> updateNotification() }
        cbOpt1.setOnCheckedChangeListener(listener)
        cbOpt2.setOnCheckedChangeListener(listener)
        cbOpt3.setOnCheckedChangeListener(listener)

        updateNotification() // Initial state

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
