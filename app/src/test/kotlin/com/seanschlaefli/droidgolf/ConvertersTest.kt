package com.seanschlaefli.droidgolf

import com.seanschlaefli.droidgolf.data.converters.Converters
import org.junit.Test

import org.junit.Assert.*

class ConvertersTest {

    @Test
    fun testFromJsonToIntList() {
        val expected: List<Int> = listOf(1,2,3)
        val json = "[1,2,3]"
        val result: List<Int> = Converters.fromJsonToIntList(json)
        assertEquals(expected.size, result.size)
        for (i in 0 until expected.size-1) {
            assertEquals(expected[i], result[i])
        }
    }

    @Test
    fun testFromJsonToBoolList() {
        val expected: List<Boolean> = listOf(true, true, false)
        val json = "[true,true,false]"
        val result: List<Boolean> = Converters.fromJsonToBoolList(json)
        assertEquals(expected.size, result.size)
        for (i in 0 until expected.size-1) {
            assertEquals(expected[i], result[i])
        }
    }

    @Test
    fun testFromIntListToJson() {
        val expected = "[1,2,3]"
        val list: List<Int> = listOf(1,2,3)
        val result: String = Converters.fromIntListToJson(list)
        assertEquals(expected, result)
    }

    @Test
    fun testFromBooleanListToJson() {
        val expected = "[true,true,false]"
        val list: List<Boolean> = listOf(true, true, false)
        val result: String = Converters.fromBooleanListToJson(list)
        assertEquals(expected, result)
    }

}