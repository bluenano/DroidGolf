package com.seanschlaefli.droidgolf.data.local.room.dao

import androidx.room.*
import com.seanschlaefli.droidgolf.data.local.room.entity.Score


@Dao
interface ScoreDao {
    @Query("SELECT * FROM score")
    fun getScores(): List<Score>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(score: Score): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(scores: List<Score>): List<Long>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(score: Score)

    @Delete
    fun delete(score: Score)

    @Query("SELECT * FROM score WHERE golfer_id=:golferId")
    fun getScoresByGolfer(golferId: Int): List<Score>
}