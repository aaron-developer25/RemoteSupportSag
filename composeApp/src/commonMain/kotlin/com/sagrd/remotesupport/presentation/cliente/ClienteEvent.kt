package com.sagrd.remotesupport.presentation.cliente

sealed interface ClienteEvent {
    data object GetClientes : ClienteEvent
}