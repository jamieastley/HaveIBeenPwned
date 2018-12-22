package com.jamie1192.haveibeenpwned.di

import android.app.Application
import com.jamie1192.haveibeenpwned.api.ApiService
import com.jamie1192.haveibeenpwned.database.AppDatabase
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

/**
 * Created by jamie1192 on 16/12/18.
 */
class App : Application() {

    val appModule = module {

        single { ApiService.create(get()) }
        single { AppDatabase.getDatabase(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}