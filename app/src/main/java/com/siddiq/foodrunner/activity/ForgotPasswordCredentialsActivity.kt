package com.siddiq.foodrunner.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.siddiq.foodrunner.R

class ForgotPasswordCredentialsActivity : AppCompatActivity() {
    lateinit var txtMobileNumberValueFP: TextView
    lateinit var txtEmailValueFP: TextView
    var getMobileNumber: String? = null
    var getEmail: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password_credentials)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        txtEmailValueFP = findViewById(R.id.txtEmailValueFP)
        txtMobileNumberValueFP = findViewById(R.id.txtMobileNumberValueFP)

        if(intent!=null){
            getMobileNumber = intent.getStringExtra("MobileNumber")
            getEmail = intent.getStringExtra("Email")
            txtMobileNumberValueFP.text = getMobileNumber
            txtEmailValueFP.text = getEmail
        }
    }
}