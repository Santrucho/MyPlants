package com.santrucho.myplants.data.model.division

import com.google.gson.annotations.SerializedName

data class SubDivision(
    @SerializedName("id")
    val id : String = "",
    @SerializedName("name")
    val name : String = "",
    @SerializedName("division")
    val division : Division
)
