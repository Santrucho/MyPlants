package com.santrucho.myplants.ui

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.santrucho.myplants.ui.common.ProgressBar
import com.santrucho.myplants.util.Resource

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlantDetailScreen(plantId: String, viewModel: PlantViewModel) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.plantDetail(plantId)
    }

    val plant = viewModel.plantState.collectAsState()
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Planta") })
    }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            plant.value?.let {
                when(it){
                    is Resource.Loading -> {
                        ProgressBar()
                    }
                    is Resource.Success -> {
                        Box(
                            modifier = Modifier
                                .height(300.dp)
                                .padding(4.dp)
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)),
                                model = it.data.imagePlant,
                                contentDescription = "plant",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(text = "Plant name: ${it.data.name}", fontSize = 22.sp)

                        Text(text = "Scientific name: ${it.data.scientificName}", fontSize = 18.sp)

                        Text(text = "Observations: ${it.data.observations}")
                    }
                    is Resource.Failure -> {
                        Toast.makeText(context,it.exception.message,Toast.LENGTH_LONG).show()

                    }
                }
            }
        }
    }

}