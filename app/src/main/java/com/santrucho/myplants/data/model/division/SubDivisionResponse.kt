package com.santrucho.myplants.data.model.division

import com.google.gson.annotations.SerializedName

data class SubDivisionResponse(
    @SerializedName("data")
    val data : List<SubDivision>
) {
}