package com.santrucho.myplants.ui.section.division.divisionOrder

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santrucho.myplants.ui.PlantViewModel
import com.santrucho.myplants.ui.common.ProgressBar
import com.santrucho.myplants.util.Resource

@Composable
fun DivisionOrderSection(subDivisionId: String?, viewModel: PlantViewModel) {
    val divisionState = viewModel.divisionOrders.collectAsState()

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        if (!subDivisionId.isNullOrEmpty()) {
            Text("Division:", fontSize = 22.sp)
            divisionState.value?.let {
                when (it) {
                    is Resource.Loading -> {
                        ProgressBar()
                    }
                    is Resource.Success -> {
                        Spacer(modifier = Modifier.padding(8.dp))
                        if (it.data.isNotEmpty()) {
                            DivisionOrderList(divisionOrders = it.data.filter { divisionOrder ->
                                divisionOrder.subDivision.id == subDivisionId
                            })
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