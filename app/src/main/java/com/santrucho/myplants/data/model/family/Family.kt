package com.santrucho.myplants.data.model.family

import com.google.gson.annotations.SerializedName
import com.santrucho.myplants.data.model.division.DivisionOrder

data class Family(
    @SerializedName("id")
    val id : String ="",
    @SerializedName("name")
    val name : String ="",
    @SerializedName("common_name")
    val commonName : String = "",
    @SerializedName("division_orders")
    val divisionOrder: DivisionOrder?
)
