package ebisus.monkagiga.kamicompapp.core.domain.repository

import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityEffectDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityOutcomeDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeDao
import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeDetails
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility
import javax.inject.Inject

class KamihimeRepository @Inject constructor(
    private val kamihimeDao: KamihimeDao,
    private val kamihimeAbilityDao: KamihimeAbilityDao,
    private val kamihimeAbilityEffectDao: KamihimeAbilityEffectDao,
    private val kamihimeAbilityOutcomeDao: KamihimeAbilityOutcomeDao,
) {

    suspend fun getKamihime(id: Long): Kamihime? = kamihimeDao.getKamihime(id)

    suspend fun getKamihimeAbilities(id: Long): List<KamihimeAbility> = kamihimeAbilityDao.getKamihimeAbilities(id)

    suspend fun getKamihimeDetails(id: Long): KamihimeDetails? {
        return kamihimeDao.getKamihimeDetails(id)
    }

    suspend fun getKamihimeDetailsList(): List<KamihimeDetails> = kamihimeDao.getKamihimeDetailsList()

    suspend fun updateKamihime(kamihime: Kamihime) {
        kamihimeDao.clearKamihime(kamihime.id)
        val kamihimeId = kamihimeDao.updateKamihime(kamihime)
        kamihime.abilities.forEach { ability ->
            ability.kamihimeId = kamihimeId
            val abilityId = kamihimeAbilityDao.updateKamihimeAbility(ability)
            ability.effects.forEach { effect ->
                effect.abilityId = abilityId
                val effectId = kamihimeAbilityEffectDao.updateKamihimeAbilityEffect(effect)
                effect.outcomes.forEach { outcome ->
                    outcome.effectId = effectId
                    kamihimeAbilityOutcomeDao.updateKamihimeAbilityOutcome(outcome)
                }
            }
        }
    }
}
