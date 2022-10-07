package com.siddiq.foodrunner.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.siddiq.foodrunner.R

class RegistrationActivity : AppCompatActivity() {
    lateinit var btnRegister: Button
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etMobileNumberRegistration: EditText
    lateinit var etAddress: EditText
    lateinit var etPasswordRegistration: EditText
    lateinit var etConfirmPassword: EditText
    var name: String? = null
    var email: String? = null
    var mobileNumber: String? = null
    var address: String? = null
    var password: String? = null
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        title = "Register Yourself"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnRegister = findViewById(R.id.btnRegister)
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMobileNumberRegistration = findViewById(R.id.etMobileNumberRegistration)
        etAddress = findViewById(R.id.etAddress)
        etPasswordRegistration = findViewById(R.id.etPasswordRegistration)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        sharedPreferences =
            getSharedPreferences(getString(R.string.shared_preferences_file), Context.MODE_PRIVATE)

        btnRegister.setOnClickListener {
            name = etName.text.toString()
            email = etEmail.text.toString()
            mobileNumber = etMobileNumberRegistration.text.toString()
            address = etAddress.text.toString()
            password = etPasswordRegistration.text.toString()

            if (etName.text.isEmpty() == true || etEmail.text.isEmpty() == true || etMobileNumberRegistration.text.isEmpty() == true || etAddress.text.isEmpty() == true || etPasswordRegistration.text.isEmpty() == true || etConfirmPassword.text.isEmpty() == true) {
                Toast.makeText(
                    this@RegistrationActivity,
                    "Please enter all the fields first",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent =
                    Intent(this@RegistrationActivity, LoginActivity::class.java)
//                intent.putExtra("Name", name)
//                intent.putExtra("Email", email)
//                intent.putExtra("MobileNumber", mobileNumber)
//                intent.putExtra("Address", address)
                sharedPreferences.edit().putString("mobile_number", mobileNumber).apply()
                sharedPreferences.edit().putString("password", password).apply()
                sharedPreferences.edit().putString("name", name).apply()
                sharedPreferences.edit().putString("email", email).apply()
                sharedPreferences.edit().putString("address", address).apply()
                Toast.makeText(this@RegistrationActivity,
                    "Registration successful!",
                    Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }

        }
    }
}