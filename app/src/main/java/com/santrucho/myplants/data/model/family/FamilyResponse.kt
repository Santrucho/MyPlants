package com.santrucho.myplants.data.model.family

import com.google.gson.annotations.SerializedName

data class FamilyResponse(
    @SerializedName("data")
    val data : List<Family>,
    @SerializedName("meta")
    val meta : Meta
)
