package com.seanschlaefli.droidgolf.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "golfer")
data class Golfer constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "golfer_id")
    var id: Int,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "firstname")
    var firstName: String,

    @ColumnInfo(name = "lastname")
    var lastName: String,

    @ColumnInfo(name = "age")
    var age: Int,

    @ColumnInfo(name = "gender")
    var gender: String,

    @ColumnInfo(name = "height")
    var height: Int,

    @ColumnInfo(name = "weight")
    var weight: Int
)