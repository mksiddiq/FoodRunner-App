package com.siddiq.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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

        btnRegister.setOnClickListener {
            name = etName.text.toString()
            email = etEmail.text.toString()
            mobileNumber = etMobileNumberRegistration.text.toString()
            address = etAddress.text.toString()
            if (etName.text.isEmpty() == true || etEmail.text.isEmpty() == true || etMobileNumberRegistration.text.isEmpty() == true || etAddress.text.isEmpty() == true || etPasswordRegistration.text.isEmpty() == true || etConfirmPassword.text.isEmpty() == true) {
                Toast.makeText(
                    this@RegistrationActivity,
                    "Please enter all the fields first",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this@RegistrationActivity, RegistrationCredentials::class.java)
                intent.putExtra("Name", name)
                intent.putExtra("Email", email)
                intent.putExtra("MobileNumber", mobileNumber)
                intent.putExtra("Address", address)
                startActivity(intent)
            }

        }
    }
}