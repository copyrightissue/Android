package com.example.chitter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "bird_sightings")
data class BirdSighting (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "bird_id")
    val birdId: Int,
    @ColumnInfo(name = "date_seen")
    val timestamp: Date
)