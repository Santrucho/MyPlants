package com.santrucho.myplants.repository

import com.santrucho.myplants.data.model.division.Division
import com.santrucho.myplants.data.model.division.DivisionOrder
import com.santrucho.myplants.data.model.division.SubDivision
import com.santrucho.myplants.data.model.family.Family
import com.santrucho.myplants.data.model.plant.Plant
import com.santrucho.myplants.data.network.ApiService
import com.santrucho.myplants.util.Resource
import javax.inject.Inject
import kotlin.RuntimeException


class DefaultPlantRepository @Inject constructor(
    private val apiService: ApiService
) : PlantRepository {

    override suspend fun getDivisions(): Resource<List<Division>> {
        return try {
            val division = apiService.getDivisions().data
            Resource.Success(division)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun getSubDivisions(): Resource<List<SubDivision>> {
        return try {
            val subDivision = apiService.getSubdivision().data
            Resource.Success(subDivision)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun getDivisionOrder(): Resource<List<DivisionOrder>> {
        return try {
            val divisionOrder = apiService.getDivisionOrder().data
            Resource.Success(divisionOrder)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun getFamilies(page: Int): Resource<List<Family>> {
        return try {
            val families = apiService.getFamilies(page = page).data
            Resource.Success(families)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }

    override suspend fun getPlants(): Resource<List<Plant>> {
        return try {
            val plants = apiService.getPlants().data
            Resource.Success(plants)
        } catch (e: Exception) {
            throw RuntimeException(e.message)
        }
    }

    override suspend fun getPlantDetail(plantId: String): Resource<Plant> {
        return try {
            val plant = apiService.getPlantDetail(plantId).data
            Resource.Success(plant)
        } catch (e: Exception) {
            Resource.Failure(e)
        }
    }
}