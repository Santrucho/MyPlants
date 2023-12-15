package com.santrucho.myplants.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.santrucho.myplants.ui.HomeScreen
import com.santrucho.myplants.ui.PlantDetailScreen
import com.santrucho.myplants.ui.PlantViewModel
import com.santrucho.myplants.ui.section.SectionScreen

@Composable
fun NavHost(navController: NavController) {
    val viewModel = viewModel<PlantViewModel>()
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.HomeScreen.route,
        builder = {

            composable(route = Screen.HomeScreen.route){
                HomeScreen(navController = navController, viewModel = viewModel)
            }

            composable(route = "${Screen.PlantDetailScreen.route}/{id}", arguments = listOf(
                navArgument("id") {type = NavType.StringType}
            )){backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                requireNotNull(id)
                PlantDetailScreen(plantId = id,viewModel = viewModel)
            }

            composable("${Screen.SectionScreen.route}/{content}", arguments = listOf(
                navArgument("content") {type = NavType.StringType}
            )){ backStackEntry ->
                val content = backStackEntry.arguments?.getString("content")
                requireNotNull(content)
                SectionScreen(content = content, navController = navController )
            }
        })
}