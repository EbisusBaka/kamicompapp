package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeDetails
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime

@Dao
interface KamihimeDao {

    @Query("SELECT * FROM Kamihime where id = :id")
    suspend fun getKamihime(id: Long): Kamihime?

    @Query("DELETE FROM Kamihime where id = :id")
    suspend fun clearKamihime(id: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateKamihime(kamihime: Kamihime): Long

    @Query("SELECT * FROM Kamihime where id = :id")
    suspend fun getKamihimeDetails(id: Long): KamihimeDetails?
}
