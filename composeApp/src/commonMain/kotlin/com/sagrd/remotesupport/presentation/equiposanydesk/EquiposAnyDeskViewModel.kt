package com.sagrd.remotesupport.presentation.equiposanydesk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.remotesupport.data.repository.EquiposAnyDeskRepository
import edu.ucne.composedemo.data.remote.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EquiposAnyDeskViewModel(
    private val equiposAnyDeskRepository: EquiposAnyDeskRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(EquiposAnyDeskUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        getEquiposAnyDesk()
    }

    private fun getEquiposAnyDesk() {
        viewModelScope.launch {
            when (val response = equiposAnyDeskRepository.getEquiposAnyDesks()) {
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(equiposAnyDesks = response.data ?: emptyList())
                    }
                }

                is Resource.Error -> {
                    _uiState.update {
                        it.copy(equiposAnyDesks = emptyList())
                    }
                }

                is Resource.Loading -> TODO()
            }
        }
    }
}