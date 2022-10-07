package com.siddiq.foodrunner.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.siddiq.foodrunner.R

class RegistrationCredentialsActivity : AppCompatActivity() {
    lateinit var txtNameValueRS: TextView
    lateinit var txtEmailValueRS: TextView
    lateinit var txtMobileNumberValueRS: TextView
    lateinit var txtAddressValueRS: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_credentials)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        txtNameValueRS = findViewById(R.id.txtNameValueRS)
        txtEmailValueRS = findViewById(R.id.txtEmailValueRS)
        txtMobileNumberValueRS = findViewById(R.id.txtMobileNumberValueRS)
        txtAddressValueRS = findViewById(R.id.txtAddressValueRS)

        if(intent!=null){
            val getName = intent.getStringExtra("Name")
            val getEmail = intent.getStringExtra("Email")
            val getMobileNumber = intent.getStringExtra("MobileNumber")
            val getAddress = intent.getStringExtra("Address")

            txtNameValueRS.text = getName
            txtEmailValueRS.text = getEmail
            txtMobileNumberValueRS.text = getMobileNumber
            txtAddressValueRS.text = getAddress
        }
    }
}