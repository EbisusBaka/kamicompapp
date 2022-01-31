package ebisus.monkagiga.kamicompapp.core.domain.embedded

import androidx.room.Embedded
import androidx.room.Relation
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityEffect

class KamihimeAbilityDetails {

    @Embedded
    lateinit var ability: KamihimeAbility

    @Relation(parentColumn = "id", entityColumn = "abilityId", entity = KamihimeAbilityEffect::class)
    lateinit var effects: List<KamihimeAbilityEffectDetails>
}
