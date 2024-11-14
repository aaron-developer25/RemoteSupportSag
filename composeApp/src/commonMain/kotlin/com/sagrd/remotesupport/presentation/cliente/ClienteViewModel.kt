package com.sagrd.remotesupport.presentation.cliente

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagrd.remotesupport.data.remote.dto.ClienteDto
import com.sagrd.remotesupport.data.repository.ClienteRepository
import edu.ucne.composedemo.data.remote.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ClienteViewModel (
    private val clienteRepository: ClienteRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(ClienteUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getClientes()
    }

    fun onEvent(event: ClienteEvent) {
        when (event) {
            ClienteEvent.GetClientes -> getClientes()
        }
    }

    private fun getClientes() {
        viewModelScope.launch {
            when (val response = clienteRepository.getClientes()) {
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(clientes = response.data ?: emptyList())
                    }
                }
                is Resource.Error -> {
                    _uiState.update {
                        it.copy( clientes = emptyList())
                    }
                }

                is Resource.Loading -> TODO()
            }
        }
    }
}

fun ClienteUiState.toEntity() = ClienteDto(
    codigoCliente = codigoCliente ?: 0,
    nombres = nombres ?: "",
    empresa = empresa ?: "",
    direccion = direccion ?: "",
    telefono = telefono ?: "",
    celular = celular ?: "",
    rnc = rnc ?: "",
    tieneIguala = tieneIguala,
    tipoComprobante = tipoComprobante ?: 0
)