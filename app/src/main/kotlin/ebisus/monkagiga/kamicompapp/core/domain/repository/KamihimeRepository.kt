package ebisus.monkagiga.kamicompapp.core.domain.repository

import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeDao
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility
import ebisus.monkagiga.kamicompapp.core.domain.models.KamihimeDetails
import javax.inject.Inject

class KamihimeRepository @Inject constructor(
    private val kamihimeDao: KamihimeDao,
    private val kamihimeAbilityDao: KamihimeAbilityDao
) {

    suspend fun getKamihime(id: Int): Kamihime? = kamihimeDao.getKamihime(id)

    suspend fun getKamihimeAbilities(id: Int): List<KamihimeAbility> = kamihimeAbilityDao.getKamihimeAbilities(id)

    suspend fun getKamihimeDetails(id: Int): KamihimeDetails? {
        val kamihime = getKamihime(id) ?: return null
        val abilities = getKamihimeAbilities(id)
        return KamihimeDetails(
            kamihime = kamihime,
            abilities = abilities
        )
    }

    suspend fun updateKamihime(kamihime: Kamihime) {
        kamihimeDao.updateKamihime(kamihime)
    }

    suspend fun updateKamihimeAbilities(kamihimeId: Int, abilities: List<KamihimeAbility>) {
        kamihimeAbilityDao.clearKamihimeAbilities(kamihimeId)
        kamihimeAbilityDao.updateKamihimeAbilities(abilities)
    }
}
