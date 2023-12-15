package com.santrucho.myplants.ui.section.division.subdivision

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santrucho.myplants.data.model.division.SubDivision


@Composable
fun SubDivisionItem(subDivision: SubDivision) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(8.dp),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = subDivision.name, fontSize = 24.sp)
                Text(text = "Division: ${subDivision.division.name}", fontSize = 18.sp)
            }
        }
    }
}