package com.example.uxpro.api

import com.google.gson.annotations.SerializedName

data class UxResponse(
    @SerializedName("data") val value: List<UxItemsResponse>
) {
    data class UxItemsResponse(
        @SerializedName("description") val description: String,
        @SerializedName("title") val title: String,
        @SerializedName("subtitle") val subTitle: String,
        @SerializedName("type") val type: String
    )
}
