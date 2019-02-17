package com.seanschlaefli.droidgolf.di

import androidx.room.Room
import com.seanschlaefli.droidgolf.App
import com.seanschlaefli.droidgolf.data.local.room.AppDatabase
import com.seanschlaefli.droidgolf.data.local.room.dao.GolferDao
import com.seanschlaefli.droidgolf.data.local.room.dao.ScoreDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "droidgolf.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideGolferDao(db: AppDatabase): GolferDao = db.golferDao()

    @Provides
    @Singleton
    fun provideScoreDao(db: AppDatabase): ScoreDao = db.scoreDao()

    // Provide other daos here

}