package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import ebisus.monkagiga.kamicompapp.core.domain.enums.Element

sealed class EffectOutcomeItem {
    data class DealsDamage(val amount: Float, val element: Element) : EffectOutcomeItem()
}
