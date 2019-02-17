package com.seanschlaefli.droidgolf.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
//import com.seanschlaefli.droidgolf.BuildConfig
import com.seanschlaefli.droidgolf.data.converters.Converters
import com.seanschlaefli.droidgolf.data.local.room.dao.GolferDao
import com.seanschlaefli.droidgolf.data.local.room.dao.ScoreDao
import com.seanschlaefli.droidgolf.data.local.room.entity.Golfer
import com.seanschlaefli.droidgolf.data.local.room.entity.Score


@Database(
    entities = [Golfer::class, Score::class],
    version = 1,//BuildConfig.VERSION_CODE,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun golferDao(): GolferDao
    abstract fun scoreDao(): ScoreDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also {
                        INSTANCE = it
                    }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "app.db").build()
    }
}

