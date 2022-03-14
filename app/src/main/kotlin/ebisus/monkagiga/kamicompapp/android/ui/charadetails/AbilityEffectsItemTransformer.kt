package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeAbilityDetails
import javax.inject.Inject

class AbilityEffectsItemTransformer @Inject constructor() {

    fun transform(abilityDetails: KamihimeAbilityDetails): List<AbilityEffectItem> {
        return abilityDetails.effects.map {
            AbilityEffectItem(
                effect = it
            )
        }
    }
}
