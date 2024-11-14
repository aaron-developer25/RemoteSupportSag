package com.sagrd.remotesupport.data.repository

import edu.ucne.composedemo.data.remote.RemoteDataSource
import edu.ucne.composedemo.data.remote.Resource
import com.sagrd.remotesupport.data.remote.dto.EquiposAnyDeskDto

class EquiposAnyDeskRepository(
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getEquiposAnyDesks(): Resource<List<EquiposAnyDeskDto>> {
        try {
            val equiposAnyDesks = remoteDataSource.getEquiposAnyDesks()

           return Resource.Success(equiposAnyDesks)
        }catch (e: Exception){
            return Resource.Error("Error desconocido: ${e.message}")
        }
    }
}