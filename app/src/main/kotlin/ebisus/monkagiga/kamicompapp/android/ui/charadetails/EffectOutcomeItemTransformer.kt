package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeAbilityEffectDetails
import ebisus.monkagiga.kamicompapp.core.domain.entities.MetadataKey
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityOutcomeType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import javax.inject.Inject

class EffectOutcomeItemTransformer @Inject constructor() {

    fun transform(effectDetails: KamihimeAbilityEffectDetails): List<EffectOutcomeItem> {
        return effectDetails.outcomes.mapNotNull { outcome ->
            when (outcome.outcomeType) {
                AbilityOutcomeType.ADDS_STATUS -> null
                AbilityOutcomeType.DEALS_DAMAGE -> {
                    val damage = outcome.metaData.values[MetadataKey.AMOUNT]?.toFloatOrNull()
                    val element = outcome.metaData.values[MetadataKey.ELEMENT]?.let { Element.valueOf(it) }
                    if (damage != null && element != null) {
                        EffectOutcomeItem.DealsDamage(damage, element)
                    } else null
                }
                AbilityOutcomeType.ADDS_BURST_GAUGE -> null
            }
        }
    }
}
