package com.apiTask.AppsSquare.Api

import com.apiTask.AppsSquare.models.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getData(): Call<DataModel>
}