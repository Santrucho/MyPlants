package com.santrucho.myplants.ui.section.family

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.santrucho.myplants.R
import com.santrucho.myplants.data.model.family.FamilyResponse
import com.santrucho.myplants.data.model.family.Meta
import com.santrucho.myplants.ui.PlantViewModel
import com.santrucho.myplants.ui.common.ProgressBar
import com.santrucho.myplants.util.Resource

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FamilyContent(navController: NavController, viewModel: PlantViewModel = hiltViewModel()) {
    val familyState = viewModel.familiesState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(key1 = viewModel.currentPage.value) {
        viewModel.getFamilies()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.famlies), fontSize = 20.sp) },
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
        Column(modifier = Modifier.fillMaxSize()) {
            familyState.value?.let {
                when (it) {
                    is Resource.Loading -> {
                        ProgressBar()
                    }

                    is Resource.Success -> {
                        FamilyList(families = it.data)
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                            Button(enabled =viewModel.currentPage.value > 1 ,onClick = {
                                viewModel.currentPage.value--
                            }){
                                Text(text = "Previous page")
                            }
                            Button(enabled= viewModel.currentPage.value < 683,onClick = {
                                viewModel.currentPage.value++
                            }){
                                Text(text = "Next page")
                            }
                        }

                    }

                    is Resource.Failure -> {
                        Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}