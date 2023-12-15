package com.santrucho.myplants.navigation

sealed class Screen (val route : String) {

    object HomeScreen : Screen(route  = "home_screen")

    object PlantDetailScreen : Screen(route = "plant_detail_screen")

    object SectionScreen : Screen(route = "section_screen")
}