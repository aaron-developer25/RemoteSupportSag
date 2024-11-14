package com.sagrd.remotesupport.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ClienteDto(
    val codigoCliente: Int,
    val nombres: String,
    val empresa: String,
    val direccion: String,
    val telefono: String,
    val celular: String,
    val rnc: String,
    val tieneIguala: Boolean,
    val tipoComprobante: Int
)