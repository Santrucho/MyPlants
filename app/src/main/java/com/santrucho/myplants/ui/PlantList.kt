package com.santrucho.myplants.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.santrucho.myplants.data.model.plant.Plant
import com.santrucho.myplants.navigation.Screen

@Composable
fun PlantList(listOfPlants: List<Plant>, navController: NavController) {
    LazyColumn(modifier = Modifier.height(700.dp)) {
        items(listOfPlants) { plant ->
            PlantItem(plant = plant, navController = navController)
        }
    }
}

@Composable
fun PlantItem(plant: Plant, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("${Screen.PlantDetailScreen.route}/${plant.id}")
            },

        backgroundColor = MaterialTheme.colors.primary,
        elevation = 6.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
                    model = plant.imagePlant,
                    contentDescription = "plant image",
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                        .background(Color.White.copy(0.4f)), contentAlignment = Alignment.Center
                ) {
                    Text(text = plant.name, fontSize = 22.sp)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                PlantChips(plant)

                IconButton(onClick = { /*TODO Save the plant into local database*/ }) {
                    Icon(imageVector = Icons.Outlined.Star, contentDescription = "fav plant")
                }
            }
        }
    }
}

@Composable
fun PlantChips(plant: Plant) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .height(28.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.primaryVariant)
                .padding(2.dp)
        ) {
            Text(text = plant.scientificName)
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.primaryVariant)
                .padding(2.dp)
        ) {
            Text(text = plant.scientificName)
        }
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.primaryVariant)
                .padding(2.dp)
        ) {
            Text(text = plant.scientificName)
        }
    }
}