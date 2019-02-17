package com.seanschlaefli.droidgolf.di.test

import com.seanschlaefli.droidgolf.data.local.room.DaoTest
import com.seanschlaefli.droidgolf.di.AppComponent
import com.seanschlaefli.droidgolf.di.AppModule
import com.seanschlaefli.droidgolf.di.DatabaseModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    DatabaseModule::class]
)
interface TestAppComponent : AppComponent {
    fun inject(test: DaoTest)
}