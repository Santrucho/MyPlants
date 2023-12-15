package com.santrucho.myplants.ui.section.family

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santrucho.myplants.data.model.family.Family

@Composable
fun FamilyList(families: List<Family>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.height(700.dp), content = {
        items(families) { family ->
            FamilyItem(family = family)
        }
    })
}

@Composable
fun FamilyItem(family: Family) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp) ,shape = RoundedCornerShape(8.dp), elevation = 6.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = family.commonName ?: "", fontSize = 18.sp)
                Text(text = "Scientific name: ${family.name}", fontSize = 16.sp)
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "go to icon"
                )
            }

        }
    }
}