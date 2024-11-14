package com.sagrd.remotesupport

import android.app.Application
import org.aarondeveloper.ejemplo1.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class RemoteSupportApp : Application() {

    companion object {
        lateinit var instance: RemoteSupportApp
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@RemoteSupportApp)
        }
    }

}
