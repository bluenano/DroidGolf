package com.seanschlaefli.droidgolf.di

import com.seanschlaefli.droidgolf.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    DatabaseModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun database(database: DatabaseModule): Builder
        // other modules here

        fun build(): AppComponent
    }

    override fun inject(app: App)
}