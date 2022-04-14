package ebisus.monkagiga.kamicompapp.android.ui.combined

import ebisus.monkagiga.kamicompapp.core.domain.embedded.KamihimeDetails
import ebisus.monkagiga.kamicompapp.core.domain.entities.Eidolon
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import javax.inject.Inject

class FilterTagHelper @Inject constructor() {

    fun getTagsFromKamihime(kamihimeDetails: KamihimeDetails): List<FilterTag> {
        return buildList {
            add(FilterTag.KAMIHIME)
            add(
                when (kamihimeDetails.kamihime.rarity) {
                    Rarity.N -> FilterTag.N
                    Rarity.R -> FilterTag.R
                    Rarity.SR -> FilterTag.SR
                    Rarity.SSR -> FilterTag.SSR
                    Rarity.FLB -> throw IllegalStateException("Kamihime cannot be FLB")
                    Rarity.ULB -> throw IllegalStateException("Kamihime cannot be ULB")
                }
            )
            if (kamihimeDetails.kamihime.postAwakenId != null) {
                add(FilterTag.CAN_AWAKEN)
            }
            if (kamihimeDetails.kamihime.preAwakenId != null) {
                add(FilterTag.AWAKENED)
            }
            add(
                when (kamihimeDetails.kamihime.element) {
                    Element.FIRE -> FilterTag.FIRE
                    Element.WATER -> FilterTag.WATER
                    Element.WIND -> FilterTag.WIND
                    Element.THUNDER -> FilterTag.THUNDER
                    Element.LIGHT -> FilterTag.LIGHT
                    Element.DARK -> FilterTag.DARK
                    Element.PHANTOM -> FilterTag.PHANTOM
                    Element.NO_ELEMENT -> FilterTag.NO_ELEMENT
                }
            )
            add(
                when (kamihimeDetails.kamihime.type) {
                    CharacterType.BALANCE -> FilterTag.BALANCE
                    CharacterType.DEFENSE -> FilterTag.DEFENSE
                    CharacterType.HEALER -> FilterTag.HEALER
                    CharacterType.OFFENSE -> FilterTag.OFFENSE
                    CharacterType.TRICKY -> FilterTag.TRICKY
                }
            )
            kamihimeDetails.kamihime.obtainLocation?.let {
                add(
                    when (it) {
                        ObtainLocation.GACHA -> FilterTag.GACHA
                        ObtainLocation.GACHA_LIMITED -> FilterTag.GACHA_LIMITED
                        ObtainLocation.EVENT -> FilterTag.EVENT
                        ObtainLocation.SHOP -> FilterTag.SHOP
                        ObtainLocation.MAIN_STORY -> FilterTag.MAIN_STORY
                    }
                )
            }
            addAll(kamihimeDetails.kamihime.additionalTags)
        }
    }

    fun getTagsFromEidolon(eidolon: Eidolon): List<FilterTag> {
        return buildList {
            add(FilterTag.EIDOLON)
            add(
                when (eidolon.rarity) {
                    Rarity.N -> FilterTag.N
                    Rarity.R -> FilterTag.R
                    Rarity.SR -> FilterTag.SR
                    Rarity.SSR -> FilterTag.SSR
                    Rarity.FLB -> FilterTag.FLB
                    Rarity.ULB -> throw IllegalStateException("Eidolon cannot be ULB")
                }
            )
            add(
                when (eidolon.element) {
                    Element.FIRE -> FilterTag.FIRE
                    Element.WATER -> FilterTag.WATER
                    Element.WIND -> FilterTag.WIND
                    Element.THUNDER -> FilterTag.THUNDER
                    Element.LIGHT -> FilterTag.LIGHT
                    Element.DARK -> FilterTag.DARK
                    Element.PHANTOM -> FilterTag.PHANTOM
                    Element.NO_ELEMENT -> FilterTag.NO_ELEMENT
                }
            )
            eidolon.obtainLocation?.let {
                add(
                    when (it) {
                        ObtainLocation.GACHA -> FilterTag.GACHA
                        ObtainLocation.GACHA_LIMITED -> FilterTag.GACHA_LIMITED
                        ObtainLocation.EVENT -> FilterTag.EVENT
                        ObtainLocation.SHOP -> FilterTag.SHOP
                        ObtainLocation.MAIN_STORY -> FilterTag.MAIN_STORY
                    }
                )
            }
            addAll(eidolon.additionalTags)
        }
    }
}
