package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.entities.Eidolon

@Dao
interface EidolonDao {

    @Query("SELECT * FROM Eidolon where id = :id")
    suspend fun getEidolon(id: Long): Eidolon?

    @Query("DELETE FROM Eidolon where id = :id")
    suspend fun clearEidolon(id: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateEidolon(eidolon: Eidolon): Long

    @Query("SELECT * FROM Eidolon")
    suspend fun getEidolonList(): List<Eidolon>
}
