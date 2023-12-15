package com.santrucho.myplants.ui.section.division.subdivision

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santrucho.myplants.data.model.division.SubDivision

@Composable
fun SubDivisionDropDown(
    subDivisions: List<SubDivision>,
    expanded: Boolean,
    selectedSubDivision: SubDivision?,
    onDivisionSelected: (SubDivision) -> Unit
) {
    var expandedState by remember { mutableStateOf(expanded) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                expandedState = true
            },
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
                Text(
                    text = selectedSubDivision?.name ?: "Select a division class",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                )
                Log.d("@@@@@@@@@@@@@@ DORPDOWN ",selectedSubDivision?.name.toString())
            }
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Toggle menu",
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            expanded = expandedState,
            onDismissRequest = {
                expandedState = false
            }
        ) {
            subDivisions.forEachIndexed { _, subDivision ->
                DropdownMenuItem(
                    onClick = {

                        onDivisionSelected(subDivision)
                        expandedState = false
                    },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    SubDivisionItem(subDivision)
                }
            }
        }
    }
}