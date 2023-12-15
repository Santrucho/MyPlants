package com.santrucho.myplants.data.model.plant

import com.google.gson.annotations.SerializedName

data class PlantResponse(
    @SerializedName("data")
    val data : List<Plant>,
    @SerializedName("current_page")
    val page : Int
)
