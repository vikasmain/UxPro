package com.example.uxpro.api

import com.google.gson.annotations.SerializedName

data class UxItemsResponse(
    @SerializedName("description") val description: String,
    @SerializedName("title") val title:String,
    @SerializedName("subtitle") val subTitle:String,
    @SerializedName("type") val type:String
)