package com.siddiq.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotPassword : AppCompatActivity() {
    lateinit var btnNext: Button
    lateinit var etMobileNumberFP: EditText
    lateinit var etEmailFP: EditText
    var mobileNumber: String? = null
    var email: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        title = "Forgot Password"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnNext = findViewById(R.id.btnNext)
        etMobileNumberFP = findViewById(R.id.etMobileNumberFP)
        etEmailFP = findViewById(R.id.etEmailFP)

        btnNext.setOnClickListener {
            mobileNumber = etMobileNumberFP.text.toString()
            email = etEmailFP.text.toString()
            if (etEmailFP.text.isEmpty() || etMobileNumberFP.text.isEmpty()) {
                Toast.makeText(
                    this@ForgotPassword,
                    "Please enter the credentials first",
                    Toast.LENGTH_SHORT
                ).show()
            } else{
                val intent = Intent(this@ForgotPassword, ForgotPasswordCredentials::class.java)
                intent.putExtra("MobileNumber", mobileNumber)
                intent.putExtra("Email", email)
                startActivity(intent)
            }
        }

    }
}