package com.santrucho.myplants.data.model.division

import com.google.gson.annotations.SerializedName

data class DivisionResponse(
    @SerializedName("data")
    val data : List<Division>
)
