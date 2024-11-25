package com.example.pampiway.network

import com.example.pampiway.model.CreateCustomer_Response
import com.example.pampiway.model.LoginResponse
import com.example.pampiway.model.VerificationRes
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthAPIs {

    @FormUrlEncoded
    @POST("/api/customer/create")
    suspend fun createCustomer(
        @Field("full_name") full_name: String,
        @Field("email") email: String,
        @Field("phone_number") phone_number: String,
        @Field("dob") dob: String
    ): Response<CreateCustomer_Response>

    @FormUrlEncoded
    @POST("/api/customer/login")
    suspend fun login(
        @Field("phone_number") phone_number: String
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("/api/customer/validate-otp")
    suspend fun verification(
        @Field("phone_number") phone_number: String,
        @Field("otp") otp: String
    ): Response<VerificationRes>
}