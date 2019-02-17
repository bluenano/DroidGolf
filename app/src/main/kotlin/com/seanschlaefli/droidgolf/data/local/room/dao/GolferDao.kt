package com.seanschlaefli.droidgolf.data.local.room.dao

import androidx.room.*
import com.seanschlaefli.droidgolf.data.local.room.entity.Golfer

@Dao
interface GolferDao {
    @Query("SELECT * FROM golfer")
    fun getGolfers(): List<Golfer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(golfer: Golfer): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(golfers: List<Golfer>): List<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(golfer: Golfer)

    @Delete
    fun delete(golfer: Golfer)

    @Query("SELECT * FROM golfer WHERE golfer_id=:golferId")
    fun loadGolferById(golferId: Int): Golfer
}