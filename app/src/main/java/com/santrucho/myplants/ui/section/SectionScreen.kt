package com.santrucho.myplants.ui.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.santrucho.myplants.R
import com.santrucho.myplants.ui.section.division.DivisionContent
import com.santrucho.myplants.ui.section.family.FamilyContent

@Composable
fun SectionScreen(content:String,navController : NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        when(content){
            stringResource(id = R.string.my_garden) -> {
                //
            }
            stringResource(id = R.string.divisions) -> {
                DivisionContent(navController = navController)
            }
            stringResource(id = R.string.famlies) -> {
                FamilyContent(navController = navController)
            }
        }
    }
}