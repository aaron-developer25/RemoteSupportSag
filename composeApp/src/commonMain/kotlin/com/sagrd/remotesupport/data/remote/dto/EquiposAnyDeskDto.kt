package com.sagrd.remotesupport.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class EquiposAnyDeskDto (
    val idEquipo : Int,
    val alias : String,
    val clave : String,
    val descripcion : String,
    val codigoCliente : Int,
    val aliasAnydesk : String
)