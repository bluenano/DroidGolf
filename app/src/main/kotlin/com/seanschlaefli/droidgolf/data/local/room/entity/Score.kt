package com.seanschlaefli.droidgolf.data.local.room.entity

import androidx.room.*

@Entity(
    tableName = "score",
    foreignKeys = [
        ForeignKey(entity = Golfer::class,
            parentColumns = arrayOf("golfer_id"),
            childColumns = arrayOf("golfer_id"),
            onDelete = ForeignKey.CASCADE)],
    indices = [Index("golfer_id")]
)
data class Score constructor(
    @PrimaryKey
    @ColumnInfo(name = "score_id")
    var scoreId: Int,

    @ColumnInfo(name = "golfer_id")
    var golferId: Int,

    @ColumnInfo(name = "strokes_per_hole)")
    var strokesPerHole: List<Int>,

    @ColumnInfo(name = "putts_per_hole")
    var puttsPerHole: List<Int>,

    @ColumnInfo(name = "greens_in_regulation")
    var greensInRegulation: List<Boolean>,

    @ColumnInfo(name = "fairways_hit")
    var fairwaysHit: List<Boolean>
)