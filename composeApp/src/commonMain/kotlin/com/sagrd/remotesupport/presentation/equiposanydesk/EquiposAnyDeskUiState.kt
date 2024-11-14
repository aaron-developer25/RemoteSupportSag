package com.sagrd.remotesupport.presentation.equiposanydesk

import com.sagrd.remotesupport.data.remote.dto.EquiposAnyDeskDto

data class EquiposAnyDeskUiState(
    val equiposAnyDesks: List<EquiposAnyDeskDto> = emptyList(),
    val errorMessage: String? = "",
    val isLoading: Boolean = false
)
