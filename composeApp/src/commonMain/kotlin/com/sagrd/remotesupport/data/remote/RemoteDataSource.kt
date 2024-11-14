package edu.ucne.composedemo.data.remote

import com.sagrd.remotesupport.data.remote.SagApi

class RemoteDataSource(
    private val sagApi: SagApi

) {
    suspend fun getClientes() = sagApi.getClientes()

    suspend fun getEquiposAnyDesks() = sagApi.getEquiposAnyDesks()

}