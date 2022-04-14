package ebisus.monkagiga.kamicompapp.android.ui.combined

import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeDetails
import ebisus.monkagiga.kamicompapp.core.domain.entities.Eidolon

sealed class CombinedListItem {
    data class CombinedListFiltersItem(val filterTagCategory: FilterTagCategory, val filters: List<FilterTag>, var enabledFilters: List<FilterTag>): CombinedListItem()
    data class CombinedListKamihimeItem(val kamihimeDetails: KamihimeDetails) : CombinedListItem()
    data class CombinedListEidolonItem(val eidolon: Eidolon) : CombinedListItem()
    data class CombinedListSoulItem(val nothing: Nothing? = null) : CombinedListItem()
}
