package com.example.KulinerMantap.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private val client = OkHttpClient.Builder().build()
    private val retrofitClient = Retrofit.Builder()
        .client(client)
        .baseUrl("https://dev.farizdotid.com/api/purwakarta/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildService(service: Class<T>): T = retrofitClient.create(service)
}