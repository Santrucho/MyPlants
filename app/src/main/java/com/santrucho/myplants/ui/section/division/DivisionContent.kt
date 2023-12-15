package com.santrucho.myplants.ui.section.division

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.santrucho.myplants.R
import com.santrucho.myplants.data.model.division.Division
import com.santrucho.myplants.data.model.division.SubDivision
import com.santrucho.myplants.ui.PlantViewModel
import com.santrucho.myplants.ui.section.division.divisionOrder.DivisionOrderSection
import com.santrucho.myplants.ui.section.division.subdivision.SubDivisionBox

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DivisionContent(navController: NavController, viewModel: PlantViewModel = hiltViewModel()) {

    var selectedDivision by remember { mutableStateOf<Division?>(null) }
    var selectedSubDivision by remember { mutableStateOf<SubDivision?>(null) }

    LaunchedEffect(key1 = Unit) {
        viewModel.getDivisions()
        viewModel.getSubDivisions()
        viewModel.getDivisionOrder()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.divisions), fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowLeft,
                            contentDescription = "go back icon",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.background
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DivisionBox(viewModel = viewModel, onDivisionSelected = { division ->
                selectedDivision = division
                selectedSubDivision = null
                viewModel.subDivisionId.value = null
            })
            SubDivisionBox(
                divisionId = viewModel.divisionId.value,
                viewModel = viewModel,
                selectedSubDivision = selectedSubDivision,
                onSubDivisionSelected = { subdiv ->
                    selectedSubDivision = subdiv
                    viewModel.subDivisionId.value = subdiv.id
                })

            DivisionOrderSection(
                subDivisionId = viewModel.subDivisionId.value,
                viewModel = viewModel
            )

        }
    }
}

