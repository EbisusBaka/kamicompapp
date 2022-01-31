package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityEffect

@Dao
interface KamihimeAbilityEffectDao {

    @Query("SELECT * FROM KamihimeAbilityEffect where abilityId = :abilityId")
    suspend fun getKamihimeAbilityEffects(abilityId: Long): List<KamihimeAbilityEffect>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateKamihimeAbilityEffect(effect: KamihimeAbilityEffect): Long
}
