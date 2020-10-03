package com.elbehiry.steller.app

import android.app.Application
import com.elbehiry.steller.app.di.appModule
import com.elbehiry.steller.shared.appContext
import com.elbehiry.steller.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class StellerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        appContext = this

        initKoin {
            androidLogger()
            androidContext(this@StellerApp)
            modules(appModule)
        }
    }
}