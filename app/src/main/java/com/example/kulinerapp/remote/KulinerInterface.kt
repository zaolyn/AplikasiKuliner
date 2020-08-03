package com.example.kulinerapp.remote

import com.example.kulinerapp.pojo.ResponseKuliner
import retrofit2.Response
import retrofit2.http.GET

interface KulinerInterface {
    @GET("https://dev.farizdotid.com/api/purwakarta/kuliner/")
    suspend fun getSummary() : Response<ResponseKuliner>
}