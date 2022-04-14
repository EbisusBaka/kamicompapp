package ebisus.monkagiga.kamicompapp.core.domain.scripts

import ebisus.monkagiga.kamicompapp.core.domain.entities.Eidolon
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import ebisus.monkagiga.kamicompapp.core.domain.repository.EidolonRepository

class PopulateEidolonScript {

    suspend fun populate(eidolonRepository: EidolonRepository) {
        eidolonRepository.updateEidolon(
            Eidolon(
                id = 103,
                name = "Orc",
                jpName = "オーク",
                rarity = Rarity.R,
                element = Element.FIRE,
                obtainLocation = ObtainLocation.MAIN_STORY,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                additionalTags = emptyList()
            )
        )
    }
}
