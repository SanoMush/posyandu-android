package com.sanomush.posyandu.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sanomush.posyandu.R
import com.sanomush.posyandu.ui.signup.SignUpActivity
import com.sanomush.posyandu.ui.login.LoginActivity
import com.sanomush.posyandu.MainActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Cek apakah pengguna sudah login
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false)

        // Jika sudah login, langsung menuju MainActivity
        if (isLoggedIn) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // Jika belum login, tampilkan pilihan login dan signup
            val btnSignUp = findViewById<Button>(R.id.btn_sign_up)
            val btnLogin = findViewById<Button>(R.id.btn_login)

            // Button Sign Up: Arahkan ke halaman SignUpActivity
            btnSignUp.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }

            // Button Login: Arahkan ke halaman LoginActivity
            btnLogin.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
