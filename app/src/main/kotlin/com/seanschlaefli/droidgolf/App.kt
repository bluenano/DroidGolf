package com.seanschlaefli.droidgolf

import android.content.Context
import com.seanschlaefli.droidgolf.di.DaggerAppComponent
import com.seanschlaefli.droidgolf.di.DatabaseModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {

    lateinit var androidInjector: AndroidInjector<out DaggerApplication>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = androidInjector

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        androidInjector = DaggerAppComponent.builder()
            .application(this)
            .database(databaseModule())
            .build()
    }

    protected open fun databaseModule(): DatabaseModule = DatabaseModule()

}