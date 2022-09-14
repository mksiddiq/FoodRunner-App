package com.siddiq.foodrunner

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginCredentials : AppCompatActivity() {
    lateinit var txtMobileNumber: TextView
    lateinit var txtPassword: TextView
    var getMobileNumber: String? = null
    var getPassword: String? = null
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_credentials)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        txtMobileNumber = findViewById(R.id.txtMobileNumber)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogout = findViewById(R.id.btnLogout)
        sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences_file), MODE_PRIVATE)

        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@LoginCredentials, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        /*if (intent != null) {
            getMobileNumber = intent.getStringExtra("MobileNumber")
            getPassword = intent.getStringExtra("Password")
            txtMobileNumber.text = getMobileNumber
            txtPassword.text = getPassword
        } else {*/
            getMobileNumber = sharedPreferences.getString("MobileNumber", "0123456789")
            getPassword = sharedPreferences.getString("Password", "xyz")
            txtMobileNumber.text = getMobileNumber
            txtPassword.text = getPassword
    }
}