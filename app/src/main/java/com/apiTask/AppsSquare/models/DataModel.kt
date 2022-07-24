package com.apiTask.AppsSquare.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("count")
    val Co_unt: Int,
    @SerializedName("data")
    val data: List<Data>
)

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("restaurant_id")
    val restaurant_id: Int,
    @SerializedName("image")
    val image: String,


)