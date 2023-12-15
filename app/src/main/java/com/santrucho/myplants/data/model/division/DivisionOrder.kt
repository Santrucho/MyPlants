package com.santrucho.myplants.data.model.division

import com.google.gson.annotations.SerializedName

data class DivisionOrder(
    @SerializedName("id")
    val id: String ="",
    @SerializedName("name")
    val name:String="",
    @SerializedName("division_class")
    val subDivision : SubDivision
)
