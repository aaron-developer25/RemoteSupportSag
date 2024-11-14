package com.sagrd.remotesupport.data.repository

import edu.ucne.composedemo.data.remote.RemoteDataSource
import edu.ucne.composedemo.data.remote.Resource
import com.sagrd.remotesupport.data.remote.dto.ClienteDto

class ClienteRepository (
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getClientes(): Resource<List<ClienteDto>> {
        try {
            val clientes = remoteDataSource.getClientes()
            return Resource.Success(clientes)
        } catch (e: Exception) {
            return Resource.Error("Error ${e.message}")
        }
    }
}