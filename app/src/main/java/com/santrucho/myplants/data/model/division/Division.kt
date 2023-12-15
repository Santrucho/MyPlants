package com.santrucho.myplants.data.model.division

import com.google.gson.annotations.SerializedName

data class Division(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    val subKingdom: String = "Tracheobionta"
)
