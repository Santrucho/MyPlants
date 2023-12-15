package com.santrucho.myplants.data.model.division

import com.google.gson.annotations.SerializedName

data class DivisionOrderResponse(
    @SerializedName("data")
    val data : List<DivisionOrder>
)
