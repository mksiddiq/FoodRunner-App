package com.siddiq.foodrunner.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.siddiq.foodrunner.R

class MyProfileFragment : Fragment() {
    lateinit var txtNameProfile: TextView
    lateinit var txtMobileNumberProfile: TextView
    lateinit var txtEmailProfile: TextView
    lateinit var txtDeliveryProfile: TextView
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)

        txtNameProfile = view.findViewById(R.id.txtNameProfile)
        txtMobileNumberProfile = view.findViewById(R.id.txtMobileNumberProfile)
        txtEmailProfile = view.findViewById(R.id.txtEmailProfile)
        txtDeliveryProfile = view.findViewById(R.id.txtDeliveryProfile)
        sharedPreferences =
            requireActivity().getSharedPreferences(getString(R.string.shared_preferences_file),
                Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("name", "User Name")
        val mobileNumber = sharedPreferences.getString("mobile_number", "100")
        val email = sharedPreferences.getString("email", "Email-ID")
        val address = sharedPreferences.getString("address", "Delivery Address")

        txtNameProfile.text = name
        txtMobileNumberProfile.text = mobileNumber
        txtEmailProfile.text = email
        txtDeliveryProfile.text = address

        return view
    }

}