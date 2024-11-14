package com.sagrd.remotesupport.data.remote

import com.sagrd.remotesupport.data.remote.dto.ClienteDto
import com.sagrd.remotesupport.data.remote.dto.EquiposAnyDeskDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class SagApi(private val client: HttpClient, private val baseUrl: String) {

    suspend fun getClientes(): List<ClienteDto> {
        return client.get("$baseUrl/api/Clientes/GetClientes") {
            header("X-API-Key", "test")
        }.body()
    }

    suspend fun getEquiposAnyDesks(): List<EquiposAnyDeskDto> {
        return client.get("$baseUrl/api/EquiposAnydesk") {
            header("X-API-Key", "test")
        }.body()
    }
}
