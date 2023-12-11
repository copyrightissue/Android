package com.example.chitter.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BirdSightingDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(sighting: BirdSighting)

    @Query("SELECT * FROM bird_sightings")
    suspend fun getAllSightings(): Flow<List<BirdSighting>>
}