package com.santrucho.myplants.repository

import com.santrucho.myplants.data.model.division.Division
import com.santrucho.myplants.data.model.division.DivisionOrder
import com.santrucho.myplants.data.model.division.SubDivision
import com.santrucho.myplants.data.model.family.Family
import com.santrucho.myplants.data.model.plant.Plant
import com.santrucho.myplants.util.Resource

interface PlantRepository {

    suspend fun getDivisions() : Resource<List<Division>>

    suspend fun getSubDivisions() : Resource<List<SubDivision>>

    suspend fun getDivisionOrder() : Resource<List<DivisionOrder>>

    suspend fun getFamilies(page:Int) : Resource<List<Family>>

    suspend fun getPlants() : Resource<List<Plant>>

    suspend fun getPlantDetail(plantId:String) : Resource<Plant>


}