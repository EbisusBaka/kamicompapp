package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime

@Dao
interface KamihimeDao {

    @Query("SELECT * FROM Kamihime where id = :id")
    suspend fun getKamihime(id: Int): Kamihime?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateKamihime(kamihime: Kamihime)
}
