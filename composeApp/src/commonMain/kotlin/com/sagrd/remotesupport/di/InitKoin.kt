package org.aarondeveloper.ejemplo1.di

import com.sagrd.remotesupport.di.appModule
import com.sagrd.remotesupport.di.dataModule
import com.sagrd.remotesupport.di.nativeModule
import com.sagrd.remotesupport.di.viewModelsModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule, dataModule, viewModelsModule, nativeModule)
    }
}