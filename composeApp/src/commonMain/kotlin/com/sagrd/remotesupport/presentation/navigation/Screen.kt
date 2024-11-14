package com.sagrd.remotesupport.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ClienteList : Screen()
    @Serializable
    data object EquiposAnyDeskList : Screen()
}