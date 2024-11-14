package com.sagrd.remotesupport.presentation.cliente

import com.sagrd.remotesupport.data.remote.dto.ClienteDto

data class ClienteUiState(
    val codigoCliente: Int? = null,
    val nombres: String? = "",
    val empresa: String? = "",
    val direccion: String? = "",
    val telefono: String? = "",
    val celular: String? = "",
    val rnc: String? = "",
    val tieneIguala: Boolean = false,
    val tipoComprobante: Int? = null,
    val clientes: List<ClienteDto> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
