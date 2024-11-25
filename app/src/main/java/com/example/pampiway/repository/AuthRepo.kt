package com.example.pampiway.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.pampiway.network.AuthAPIs
import com.example.pampiway.utility.LOCATION
import com.example.pampiway.utility.MyComponents
import com.example.pampiway.utility.MyComponents.authAPI
import com.example.pampiway.utility.VERIFICATION

class AuthRepo(val authAPIs: AuthAPIs, private val context: Context) {


    init {
        Log.d("Repo:","Created")
    }

    suspend fun createCustomer(full_name: String, email: String, phone_number: String, dob: String){
        try{
            val createCustomerResponse = authAPI.createCustomer(full_name, email, phone_number, dob)
            if(createCustomerResponse.isSuccessful){
                Log.d("Create Customer Response","Customer Created Successfully")
                Log.d("Register", "registerUser: Successful")

            }else if (createCustomerResponse.code() == 400){
                Log.d("Create Customer Response", "User already registered")
                Toast.makeText(context,"User already registered", Toast.LENGTH_LONG).show()
            }

            else{
                Log.d("Create Customer Response","Customer Created unsuccessfully")

                Log.d("Create Customer Response","Creation Failed" + createCustomerResponse.errorBody().toString())
            }
        }
        catch (e:Exception){
            Log.d("Error: ",e.toString())
        }
    }

    suspend fun login(phone_number: String){
        try{
            val loginResponse = authAPI.login(phone_number)
            if(loginResponse.isSuccessful){
                val responseMessage = loginResponse.body()?.message ?: ""

                // Use regex to extract the OTP from the message
//                val otpRegex = Regex(",\\s*(\\d{6})\\s*via SMS")  // Adjust to match the OTP pattern, e.g., 6 digits
                val otpRegex = Regex("(\\d{6})\\s")
                val otp = otpRegex.find(responseMessage)?.value ?: "OTP not found"

                // Update the ViewModel with the OTP
                MyComponents.mainViewModel.otp.value = otp

                Log.d("OTP", MyComponents.mainViewModel.otp.value)

                Log.d("Login Response","Login Successfully")
                MyComponents.navController.navigate(VERIFICATION)
            }else{
                Log.d("Login Response","Login unsuccessfully")

                Log.d("Login Response","Login" + loginResponse.errorBody().toString())
            }
        }
        catch (e:Exception){
            Log.d("Error: ",e.toString())
        }
    }

    suspend fun verification(phone_number: String, otp: String){
        try{
            val verificationRes = authAPI.verification(phone_number, otp)
            if(verificationRes.isSuccessful){
                Log.d("Verification Response","Verification Successfully")
                MyComponents.navController.navigate(LOCATION)
            }else{
                Log.d("Verification Response","Verification unsuccessfully")

                Log.d("Verification Response","Verification" + verificationRes.errorBody().toString())
            }
        }
        catch (e:Exception){
            Log.d("Error: ",e.toString())
        }
    }

}