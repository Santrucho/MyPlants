package com.santrucho.myplants.ui


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santrucho.myplants.data.model.division.Division
import com.santrucho.myplants.data.model.division.DivisionOrder
import com.santrucho.myplants.data.model.division.SubDivision
import com.santrucho.myplants.data.model.family.Family
import com.santrucho.myplants.data.model.plant.Plant
import com.santrucho.myplants.repository.PlantRepository
import com.santrucho.myplants.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantViewModel @Inject constructor(private val plantRepository: PlantRepository) :
    ViewModel() {


    var currentPage: MutableState<Int> = mutableStateOf(1)

    var divisionId: MutableState<String> = mutableStateOf("")

    var subDivisionId: MutableState<String?> = mutableStateOf("")

    private val _allDivisionState = MutableStateFlow<Resource<List<Division>>?>(null)
    var allDivisionState = _allDivisionState.asStateFlow()

    private val _allSubDivision = MutableStateFlow<Resource<List<SubDivision>>?>(null)
    var allSubDivision = _allSubDivision.asStateFlow()

    private val _divisionOrders = MutableStateFlow<Resource<List<DivisionOrder>>?>(null)
    val divisionOrders = _divisionOrders.asStateFlow()

    private val _familiesState = MutableStateFlow<Resource<List<Family>>?>(null)
    val familiesState = _familiesState.asStateFlow()

    private val _allPlantsState = MutableStateFlow<Resource<List<Plant>>?>(null)
    var allPlantsState = _allPlantsState.asStateFlow()

    private val _plantState = MutableStateFlow<Resource<Plant>?>(null)
    var plantState = _plantState.asStateFlow()


    fun getDivisions() {
        viewModelScope.launch {
            _allDivisionState.value = Resource.Loading()
            _allDivisionState.value = plantRepository.getDivisions()
        }
    }

    fun getSubDivisions() {
        viewModelScope.launch {
            _allSubDivision.value = Resource.Loading()
            _allSubDivision.value = plantRepository.getSubDivisions()
        }
    }

    fun getDivisionOrder() {
        viewModelScope.launch {
            _divisionOrders.value = Resource.Loading()
            _divisionOrders.value = plantRepository.getDivisionOrder()
        }
    }

    fun getFamilies() {
        viewModelScope.launch {
            _familiesState.value = Resource.Loading()
            _familiesState.value = plantRepository.getFamilies(currentPage.value)

        }
    }

    fun getPlants() {
        viewModelScope.launch {
            _allPlantsState.value = Resource.Loading()
            _allPlantsState.value = plantRepository.getPlants()
        }
    }

    fun plantDetail(plantId: String) {
        viewModelScope.launch {
            _plantState.value = Resource.Loading()
            _plantState.value = plantRepository.getPlantDetail(plantId = plantId)
        }
    }

}