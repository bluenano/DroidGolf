package com.seanschlaefli.droidgolf.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromJsonToIntList(json: String): List<Int> {
            return Gson().fromJson(json, Array<Int>::class.java).asList()
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonToBoolList(json: String): List<Boolean> {
            return Gson().fromJson(json, Array<Boolean>::class.java).asList()

        }

        @TypeConverter
        @JvmStatic
        fun fromIntListToJson(list: List<Int>): String {
            return Gson().toJson(list)
        }

        @TypeConverter
        @JvmStatic
        fun fromBooleanListToJson(list: List<Boolean>): String {
            return Gson().toJson(list)
        }
    }
}