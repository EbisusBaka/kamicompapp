package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility

@Dao
interface KamihimeAbilityDao {

    @Query("SELECT * FROM KamihimeAbility where kamihimeId = :kamihimeId")
    suspend fun getKamihimeAbilities(kamihimeId: Long): List<KamihimeAbility>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateKamihimeAbility(ability: KamihimeAbility): Long
}
