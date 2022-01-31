package ebisus.monkagiga.kamicompapp.core.domain.embedded

import androidx.room.Embedded
import androidx.room.Relation
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityEffect
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityOutcome

class KamihimeAbilityEffectDetails {

    @Embedded
    lateinit var effect: KamihimeAbilityEffect

    @Relation(parentColumn = "id", entityColumn = "effectId", entity = KamihimeAbilityOutcome::class)
    lateinit var outcomes: List<KamihimeAbilityOutcome>
}
