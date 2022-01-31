package ebisus.monkagiga.kamicompapp.core.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityOutcome

@Dao
interface KamihimeAbilityOutcomeDao {

    @Query("SELECT * FROM KamihimeAbilityOutcome where effectId = :effectId")
    suspend fun getKamihimeAbilityEffectOutcomes(effectId: Long): List<KamihimeAbilityOutcome>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateKamihimeAbilityOutcome(outcome: KamihimeAbilityOutcome): Long
}
