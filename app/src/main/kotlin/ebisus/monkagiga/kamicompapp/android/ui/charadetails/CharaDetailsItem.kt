package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeAbilityDetails

sealed class CharaDetailsItem {

    data class Image(val imageUrl: String, val sfw: Boolean) : CharaDetailsItem()
    data class Ability(val ability: KamihimeAbilityDetails, val abilityIconUrl: String) : CharaDetailsItem()
}
