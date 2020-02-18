package com.eddsato.popularmovies

import android.app.Application
import com.eddsato.popularmovies.di.applicationModule
import org.koin.android.ext.android.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }
}