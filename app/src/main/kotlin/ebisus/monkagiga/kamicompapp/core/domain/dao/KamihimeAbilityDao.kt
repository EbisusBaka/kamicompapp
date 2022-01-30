package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility

@Dao
interface KamihimeAbilityDao {

    @Query("SELECT * FROM KamihimeAbility where kamihimeId = :kamihimeId")
    suspend fun getKamihimeAbilities(kamihimeId: Int): List<KamihimeAbility>

    @Query("DELETE FROM KamihimeAbility where kamihimeId = :kamihimeId")
    suspend fun clearKamihimeAbilities(kamihimeId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateKamihimeAbilities(abilities: List<KamihimeAbility>)
}
