package com.sagrd.remotesupport.presentation.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sagrd.remotesupport.presentation.cliente.ClienteListScreen
import com.sagrd.remotesupport.presentation.equiposanydesk.EquipoAnyDeskListScreen
import edu.ucne.composedemo.presentation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun SagNavHost(
    navHostController: NavHostController
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    DrawerMenu(
        drawerState = drawerState,
        navHostController = navHostController
    ) {
        NavHost(
            navController = navHostController,
            startDestination = Screen.SistemaList
        ) {


            composable<Screen.ClienteList> {
                ClienteListScreen(
                    onDrawer = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            }

            composable<Screen.EquiposAnyDeskList> {
                EquipoAnyDeskListScreen(
                    onDrawer = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            }
        }
    }
}