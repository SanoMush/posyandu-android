package com.sanomush.posyandu.ui.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.sanomush.posyandu.R
import com.sanomush.posyandu.MainActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.et_login_username)
        val etPassword = findViewById<EditText>(R.id.et_login_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Misalnya, cek email dan password (bisa dihubungkan dengan backend)
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Simpan status login di SharedPreferences
                val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
                val editor = sharedPreferences.edit()
                editor.putBoolean("IS_LOGGED_IN", true) // Tandai pengguna sudah login
                editor.putString("EMAIL", email)
                editor.apply()

                // Arahkan ke MainActivity setelah login berhasil
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Tutup LoginActivity
            } else {
                // Tampilkan pesan error jika email/password kosong
                // Misalnya menggunakan Toast atau validasi lebih lanjut
            }
        }
    }
}
