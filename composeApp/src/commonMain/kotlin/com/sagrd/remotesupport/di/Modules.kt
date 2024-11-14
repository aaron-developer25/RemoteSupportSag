package com.sagrd.remotesupport.di

import androidx.room.RoomDatabaseConstructor
import com.sagrd.remotesupport.data.local.database.SagDB
import com.sagrd.remotesupport.data.repository.ClienteRepository
import com.sagrd.remotesupport.data.repository.EquiposAnyDeskRepository
import com.sagrd.remotesupport.presentation.cliente.ClienteViewModel
import com.sagrd.remotesupport.presentation.equiposanydesk.EquiposAnyDeskViewModel
import edu.ucne.composedemo.data.remote.RemoteDataSource
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("apiClient")) { provideKtorClient() }
    single(named("sagApi")) { provideSagApi(get(named("apiClient"))) }
}

val dataModule = module {
    factoryOf(::ClienteRepository)
    factoryOf(::EquiposAnyDeskRepository)
    factory<RemoteDataSource> { RemoteDataSource(get(named("sagApi"))) }
}

val viewModelsModule = module {
    factoryOf(::ClienteViewModel)
    factoryOf(::EquiposAnyDeskViewModel)
}

expect val nativeModule: Module
