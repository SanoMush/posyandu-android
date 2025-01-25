package com.sanomush.posyandu

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sanomush.posyandu.ui.home.HomeFragment
import com.sanomush.posyandu.ui.message.MessageFragment
import com.sanomush.posyandu.ui.search.SearchFragment
import com.sanomush.posyandu.ui.setting.SettingFragment
import com.sanomush.posyandu.ui.welcome.WelcomeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isLoggedIn = sharedPreferences.getBoolean("IS_LOGGED_IN", false)

        if (!isLoggedIn) {
            // Jika belum login, langsung arahkan ke WelcomeActivity
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri MainActivity agar tidak bisa kembali
            return
        }

        // Jika sudah login, lanjutkan untuk set layout dan tampilkan fragmen
        setContentView(R.layout.activity_main)

        // Setup BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Load default fragment (misalnya Home)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        // Handle navigation item selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.home -> HomeFragment()
                R.id.search -> SearchFragment()
                R.id.message -> MessageFragment()
                R.id.settings -> SettingFragment()
                else -> null
            }

            selectedFragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, it)
                    .commit()
            }

            true
        }
    }

    // Fungsi untuk logout dan menghapus data login saat aplikasi ditutup
    override fun onStop() {
        super.onStop()

        // Menghapus status login dari SharedPreferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putBoolean("IS_LOGGED_IN", false)  // Mengubah status login menjadi false
        editor.apply()  // Simpan perubahan ke SharedPreferences
    }

    // Alternatif: bisa juga menggunakan onDestroy jika lebih ingin logout saat aplikasi benar-benar dihentikan
    override fun onDestroy() {
        super.onDestroy()

        // Menghapus status login dari SharedPreferences
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putBoolean("IS_LOGGED_IN", false)  // Mengubah status login menjadi false
        editor.apply()  // Simpan perubahan ke SharedPreferences
    }
}
