package com.santrucho.myplants.data.network

import com.santrucho.myplants.data.model.division.DivisionOrder
import com.santrucho.myplants.data.model.division.DivisionOrderResponse
import com.santrucho.myplants.data.model.division.DivisionResponse
import com.santrucho.myplants.data.model.division.SubDivisionResponse
import com.santrucho.myplants.data.model.family.FamilyResponse
import com.santrucho.myplants.data.model.plant.PlantData
import com.santrucho.myplants.data.model.plant.PlantResponse
import com.santrucho.myplants.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("plants")
    suspend fun getPlants(@Query("token")token : String = API_KEY): PlantResponse

    @GET("plants/{id}?token=$API_KEY")
    suspend fun getPlantDetail(
        @Path("id") id: String
    ): PlantData

    @GET("divisions")
    suspend fun getDivisions(@Query("token")token:String = API_KEY) : DivisionResponse

    @GET("division_classes")
    suspend fun getSubdivision(@Query("token")token:String = API_KEY) : SubDivisionResponse

    @GET("division_orders")
    suspend fun getDivisionOrder(@Query("token")token:String = API_KEY) : DivisionOrderResponse

    @GET("families")
    suspend fun getFamilies(@Query("token")token:String= API_KEY,@Query("page")page:Int) : FamilyResponse
}