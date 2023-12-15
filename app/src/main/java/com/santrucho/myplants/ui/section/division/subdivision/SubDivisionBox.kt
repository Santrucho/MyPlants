package com.santrucho.myplants.ui.section.division.subdivision

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santrucho.myplants.data.model.division.SubDivision
import com.santrucho.myplants.ui.PlantViewModel
import com.santrucho.myplants.util.Resource

@Composable
fun SubDivisionBox(
    divisionId: String,
    viewModel: PlantViewModel,
    selectedSubDivision:SubDivision?,
    onSubDivisionSelected: (SubDivision) -> Unit
) {

    val context = LocalContext.current
    val subDivisionState = viewModel.allSubDivision.collectAsState()

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (divisionId.isNotEmpty()) {


            Text("Division Classes", fontSize = 22.sp)
            subDivisionState.value?.let {
                when (it) {
                    is Resource.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is Resource.Success -> {
                        Spacer(modifier = Modifier.padding(8.dp))
                        if (it.data.isNotEmpty()) {
                            SubDivisionDropDown(
                                subDivisions = it.data.filter { subDiv ->
                                    subDiv.division.id == divisionId
                                },
                                expanded = expanded,
                                selectedSubDivision = selectedSubDivision,
                                onDivisionSelected = { subDivision ->
                                    onSubDivisionSelected(subDivision)
                                }
                            )
                        }
                    }

                    is Resource.Failure -> {
                        Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}