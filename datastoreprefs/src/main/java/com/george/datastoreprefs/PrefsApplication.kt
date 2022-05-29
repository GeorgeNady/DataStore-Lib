package com.george.datastoreprefs

import android.app.Application
import com.george.datastoreprefs.di.appModule
import org.koin.core.context.GlobalContext.startKoin

internal class PrefsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { modules(appModule) }
    }
}