package com.seanschlaefli.droidgolf.data.local.room

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.seanschlaefli.droidgolf.data.local.room.dao.GolferDao
import com.seanschlaefli.droidgolf.data.local.room.dao.ScoreDao
import com.seanschlaefli.droidgolf.data.local.room.entity.Golfer
import com.seanschlaefli.droidgolf.data.local.room.entity.Score

import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class DaoTest {

    lateinit var database: AppDatabase
    lateinit var golferDao: GolferDao
    lateinit var scoreDao: ScoreDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        golferDao = database.golferDao()
        scoreDao = database.scoreDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun testGolferDaoInsert() {
        val golfer = Golfer(1, "username", "firstname", "lastname",
            18, "male", 172, 160)
        golferDao.insert(golfer)
        var result = golferDao.getGolfers()
        assertEquals(result.size, 1)
        assertEquals(result[0], golfer)
        golfer.id = 2
        val golfers = listOf(golfer, Golfer(3, "username", "firstname",
            "lastname", 18, "male", 172, 160))
        golferDao.insertAll(golfers)
        result = golferDao.getGolfers()
        assertEquals(result.size, 3)
    }

    @Test
    fun testGolferDaoUpdate() {
        val golfer = Golfer(1, "username", "firstname", "lastname",
            18, "male", 172, 160)
        golferDao.insert(golfer)
        golfer.username = "username2"
        golferDao.update(golfer)
        val result = golferDao.loadGolferById(1)
        assertEquals(result, golfer)
    }

    @Test
    fun testGolferDaoDelete() {
        val golfer = Golfer(1, "username", "firstname", "lastname",
            18, "male", 172, 160)
        golferDao.insert(golfer)
        golferDao.delete(golfer)
        val result = golferDao.getGolfers()
        assertEquals(result.size, 0)
    }

    @Test
    fun testScoreDaoInsert() {
        val golfer = Golfer(1, "username", "firstname", "lastname",
            18, "male", 172, 160)
        golferDao.insert(golfer)
        val score = Score(1, 1, listOf(1), listOf(1), listOf(true), listOf(true))
        scoreDao.insert(score)
        val result = scoreDao.getScores()
        assertEquals(result.size, 1)
        assertEquals(result[0], score)
    }

    @Test
    fun testScoreDaoUpdate() {
        val golfer = Golfer(1, "username", "firstname", "lastname",
            18, "male", 172, 160)
        golferDao.insert(golfer)
        val score = Score(1, 1, listOf(1), listOf(1), listOf(true), listOf(true))
        scoreDao.insert(score)
        score.fairwaysHit = listOf(false)
        scoreDao.update(score)
        val result = scoreDao.getScoresByGolfer(1)
        assertEquals(result.size, 1)
        assertEquals(result[0], score)
    }

    @Test
    fun testScoreDaoDelete() {
        val golfer = Golfer(1, "username", "firstname", "lastname",
            18, "male", 172, 160)
        golferDao.insert(golfer)
        val score = Score(1, 1, listOf(1), listOf(1), listOf(true), listOf(true))
        scoreDao.insert(score)
        scoreDao.delete(score)
        val result = scoreDao.getScores()
        assertEquals(result.size, 0)
    }
}