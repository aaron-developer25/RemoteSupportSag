package com.sagrd.remotesupport.presentation.equiposanydesk

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sagrd.remotesupport.data.remote.dto.EquiposAnyDeskDto
import edu.ucne.composedemo.presentation.components.TopBarComponent
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EquipoAnyDeskListScreen(
    viewModel: EquiposAnyDeskViewModel = koinViewModel(),
    onDrawer: () -> Unit
){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    EquipoAnyDeskListBodyScreen(
        uiState = uiState,
        onDrawer = onDrawer
    )
}

@Composable
fun EquipoAnyDeskListBodyScreen(
    uiState: EquiposAnyDeskUiState,
    onDrawer: () -> Unit
){
    Scaffold(Modifier.fillMaxSize(),
        topBar = {
           TopBarComponent(
               title = "Equipos AnyDesks",
               onDrawer
           )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Spacer(modifier = Modifier
                .height(32.dp))

            when {
                uiState.isLoading ->{
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                else ->{
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(uiState.equiposAnyDesks){
                            EquipoAnyDeskRow(it)
                        }
                    }
                }
            }
        }

    }
}

@Composable
private fun EquipoAnyDeskRow(
    it : EquiposAnyDeskDto
){
    Column (modifier = Modifier.fillMaxSize()){
        Row(verticalAlignment = Alignment.CenterVertically,
        ){
            Text(modifier = Modifier.weight(1f), text = it.idEquipo.toString())
            Text(modifier = Modifier.weight(1f), text = it.alias)
            Text(modifier = Modifier.weight(1f), text = it.clave)
            Text(modifier = Modifier.weight(1f), text = it.descripcion)
            Text(modifier = Modifier.weight(1f), text = it.codigoCliente.toString())
            Text(modifier = Modifier.weight(1f), text = it.aliasAnydesk)
        }
    }
}

