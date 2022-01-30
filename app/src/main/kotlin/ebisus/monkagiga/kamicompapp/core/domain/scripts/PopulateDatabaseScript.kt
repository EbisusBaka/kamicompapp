package ebisus.monkagiga.kamicompapp.core.domain.scripts

import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import javax.inject.Inject

class PopulateDatabaseScript @Inject constructor(
    private val kamihimeRepository: KamihimeRepository
) {

    suspend fun populate() {
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5001,
                name = "Michael",
                jpName = "ミカエル",
                rarity = Rarity.SSR,
                element = Element.LIGHT,
                type = CharacterType.BALANCE,
                quote = "\"One of three archangels and a legendary Kamihime. Her power rivals that of the gods, but she despises housework of all kinds.\"",
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5002,
                name = "Amaterasu",
                jpName = "アマテラス",
                rarity = Rarity.SSR,
                element = Element.FIRE,
                type = CharacterType.DEFENSE,
                quote = "\"The sun goddess who guarded over a once prosperous eastern island nation. This classy, beautiful lady loves the aesthetics of man-on-man action.\"",
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null
            )
        )
    }
}
