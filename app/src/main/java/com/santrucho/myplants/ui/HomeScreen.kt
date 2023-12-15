package com.santrucho.myplants.ui

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.santrucho.myplants.R
import com.santrucho.myplants.data.model.plant.Plant
import com.santrucho.myplants.navigation.Screen
import com.santrucho.myplants.ui.common.ProgressBar
import com.santrucho.myplants.ui.component.SectionCard
import com.santrucho.myplants.util.Resource

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, viewModel: PlantViewModel) {

    val context = LocalContext.current
    val plants = viewModel.allPlantsState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.getPlants()
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 38.sp,
                    textAlign = TextAlign.Center
                )
            }
        }, backgroundColor = MaterialTheme.colors.background)
    }) {

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.padding(8.dp))
            SectionCard(
                text = stringResource(id = R.string.my_garden),
                navController = navController
            )

            SectionCard(text = stringResource(R.string.divisions), navController = navController)

            SectionCard(text = stringResource(id = R.string.famlies), navController = navController)

            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.plants), fontSize = 24.sp)
            }

            plants.value?.let {
                when (it) {
                    is Resource.Loading -> {
                        ProgressBar()
                    }

                    is Resource.Success -> {
                        PlantList(
                            listOfPlants = it.data,
                            navController = navController
                        )
                    }

                    is Resource.Failure -> {
                        Toast.makeText(context, it.exception.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

