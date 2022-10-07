package com.siddiq.foodrunner.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.siddiq.foodrunner.R

class LoginActivity : AppCompatActivity() {
    lateinit var txtForgotPassword: TextView
    lateinit var txtSignUp: TextView
    lateinit var btnLogin: Button
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    var mobileNumber: String? = null
    var password: String? = null
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtSignUp = findViewById(R.id.txtSignUp)
        btnLogin = findViewById(R.id.btnLogin)
        etMobileNumber = findViewById(R.id.etMobileNumberLogin)
        etPassword = findViewById(R.id.etPassword)
        sharedPreferences =
            getSharedPreferences(getString(R.string.shared_preferences_file), MODE_PRIVATE)

        title = "Login"

        var isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        txtForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        txtSignUp.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent1)
        }

        btnLogin.setOnClickListener {
            mobileNumber = etMobileNumber.text.toString()
            password = etPassword.text.toString()
            if (etMobileNumber.text.isEmpty() == true || etPassword.text.isEmpty() == true) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter both the credentials first",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)

                val mobileNumberSP = sharedPreferences.getString("mobile_number", "100")
                val passwordSP = sharedPreferences.getString("password", "default")
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

                if (mobileNumber.equals(mobileNumberSP) && password.equals(passwordSP)) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity,
                        "Enter valid credentials or register first",
                        Toast.LENGTH_SHORT).show()
                }

//                intent2.putExtra("MobileNumber", mobileNumber)
//                intent2.putExtra("Password", password)
//                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
//                sharedPreferences.edit().putString("MobileNumber", mobileNumber).apply()
//                sharedPreferences.edit().putString("Password", password).apply()

            }

        }
        //editText.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0)
    }

}