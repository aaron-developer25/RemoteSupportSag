package com.sagrd.remotesupport

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.sagrd.remotesupport.presentation.navigation.SagNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext


@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            val navHost = rememberNavController()
            SagNavHost(navHost)
        }
    }
}