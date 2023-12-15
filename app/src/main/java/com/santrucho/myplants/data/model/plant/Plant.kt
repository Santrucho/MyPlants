package com.santrucho.myplants.data.model.plant

import com.google.gson.annotations.SerializedName

data class Plant(
    @SerializedName("id")
    val id : String = "",
    @SerializedName("slug")
    val slug : String = "",
    @SerializedName("common_name")
    val name : String = "",
    @SerializedName("image_url")
    val imagePlant : String = "",
    @SerializedName("scientific_name")
    val scientificName : String = "",
    @SerializedName("observations")
    val observations : String = "",
    @SerializedName("year")
    val year : Int = 0
)
