package com.santrucho.myplants.data.model.plant

import com.google.gson.annotations.SerializedName

data class PlantData(
    @SerializedName("data")
    val data : Plant
)