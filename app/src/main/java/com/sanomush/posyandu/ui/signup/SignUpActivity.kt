package com.sanomush.posyandu.ui.signup

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.sanomush.posyandu.R
import com.sanomush.posyandu.MainActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnSignUp = findViewById<Button>(R.id.btn_sign_up)

        btnSignUp.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Menyimpan status login di SharedPreferences
                val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
                val editor = sharedPreferences.edit()
                editor.putBoolean("IS_LOGGED_IN", true) // Menandakan pengguna sudah login
                editor.putString("USERNAME", username)
                editor.putString("EMAIL", email)
                editor.apply()

                // Arahkan ke MainActivity setelah berhasil signup
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Tutup SignUpActivity
            } else {
                // Tampilkan pesan error jika ada kolom yang kosong
                // Misalnya, menggunakan Toast atau validasi lebih lanjut
            }
        }
    }
}
