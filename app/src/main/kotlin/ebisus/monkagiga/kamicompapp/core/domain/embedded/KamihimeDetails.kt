package ebisus.monkagiga.kamicompapp.core.domain.embedded

import androidx.room.Embedded
import androidx.room.Relation
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility

class KamihimeDetails {

    @Embedded
    lateinit var kamihime: Kamihime

    @Relation(parentColumn = "id", entityColumn = "kamihimeId", entity = KamihimeAbility::class)
    lateinit var abilities: List<KamihimeAbilityDetails>
}
