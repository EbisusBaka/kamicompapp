package ebisus.monkagiga.kamicompapp.core.domain.scripts

import ebisus.monkagiga.kamicompapp.android.ui.combined.FilterTag
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository

class PopulateKamihimeScript {

    suspend fun populate(kamihimeRepository: KamihimeRepository) {
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 1,
                name = "Satan",
                jpName = "サタン",
                rarity = Rarity.SSR,
                element = Element.DARK,
                type = CharacterType.TRICKY,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 3,
                name = "Sol",
                jpName = "ソル",
                rarity = Rarity.SSR,
                element = Element.LIGHT,
                type = CharacterType.HEALER,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 7,
                name = "Gaia",
                jpName = "ガイア",
                rarity = Rarity.SSR,
                element = Element.WIND,
                type = CharacterType.DEFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 11,
                name = "Tyr",
                jpName = "テュール",
                rarity = Rarity.SSR,
                element = Element.THUNDER,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 12,
                name = "Ares",
                jpName = "アレス",
                rarity = Rarity.SSR,
                element = Element.FIRE,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 16,
                name = "Shiva",
                jpName = "シヴァ",
                rarity = Rarity.SSR,
                element = Element.WATER,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 19,
                name = "Beelzebub",
                jpName = "ベルゼブブ",
                rarity = Rarity.SR,
                element = Element.DARK,
                type = CharacterType.TRICKY,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = null,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 24,
                name = "Artemis",
                jpName = "アルテミス",
                rarity = Rarity.SR,
                element = Element.LIGHT,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = null,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 26,
                name = "Nike",
                jpName = "ニケ",
                rarity = Rarity.SR,
                element = Element.WATER,
                type = CharacterType.HEALER,
                quote = null,
                obtainLocation = ObtainLocation.MAIN_STORY,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = null,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 28,
                name = "Cybele",
                jpName = "キュベレー",
                rarity = Rarity.SR,
                element = Element.WIND,
                type = CharacterType.TRICKY,
                quote = null,
                obtainLocation = ObtainLocation.MAIN_STORY,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = null,
                additionalTags = emptyList()
            )
        )
        /*TODO: himes between 30 and 5000 */

        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5001,
                name = "Michael",
                jpName = "ミカエル",
                rarity = Rarity.SSR,
                element = Element.LIGHT,
                type = CharacterType.BALANCE,
                quote = "\"One of three archangels and a legendary Kamihime. Her power rivals that of the gods, but she despises housework of all kinds.\"",
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = listOf(
                    FilterTag.LIGHT_ATK_UP_A,
                    FilterTag.DARK_RST_UP_A
                )
                /*abilities = listOf(
                    KamihimeAbility(
                        index = 0,
                        name = "Holy Ascension",
                        cooldownSeconds = 7,
                        abilityColor = AbilityColor.RED,
                        abilityIconId = 33,
                        effect = KamihimeAbilityEffect(
                            condition = AbilityEffectCondition.NO_CONDITION,
                            abilityTarget = AbilityTarget.ALL_ENEMIES,
                            outcome = KamihimeAbilityOutcome(
                                outcomeType = AbilityOutcomeType.DEALS_DAMAGE,
                                metaData = GenericMetadata(
                                    MetadataKey.AMOUNT to 2.5,
                                    MetadataKey.ELEMENT to Element.LIGHT.name
                                )
                            )
                        )
                    ),
                    KamihimeAbility(
                        index = 1,
                        name = "San Michel",
                        cooldownSeconds = 7,
                        abilityColor = AbilityColor.YELLOW,
                        abilityIconId = 17,
                        effect = KamihimeAbilityEffect(
                            condition = AbilityEffectCondition.NO_CONDITION,
                            abilityTarget = AbilityTarget.TEAM,
                            outcome = KamihimeAbilityOutcome(
                                outcomeType = AbilityOutcomeType.ADDS_BURST_GAUGE,
                                metaData = GenericMetadata(
                                    MetadataKey.AMOUNT to 20
                                )
                            )
                        )
                    ),
                    KamihimeAbility(
                        index = 2,
                        name = "Sacred Conviction",
                        cooldownSeconds = 8,
                        abilityColor = AbilityColor.YELLOW,
                        abilityIconId = 11,
                        effect = KamihimeAbilityEffect(
                            condition = AbilityEffectCondition.NO_CONDITION,
                            abilityTarget = AbilityTarget.TEAM,
                            outcomes = listOf(
                                KamihimeAbilityOutcome(
                                    outcomeType = AbilityOutcomeType.ADDS_STATUS,
                                    metaData = GenericMetadata(
                                        MetadataKey.STATUS_ID to 105,
                                        MetadataKey.AMOUNT to 0.15
                                    )
                                ),
                                KamihimeAbilityOutcome(
                                    outcomeType = AbilityOutcomeType.ADDS_STATUS,
                                    metaData = GenericMetadata(
                                        MetadataKey.STATUS_ID to 118,
                                        MetadataKey.AMOUNT to 0.25
                                    )
                                )
                            )
                        )
                    )
                )*/
            )
        )

        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5002,
                name = "Amaterasu",
                jpName = "アマテラス",
                rarity = Rarity.SSR,
                element = Element.FIRE,
                type = CharacterType.DEFENSE,
                quote = StringBuilder("\"The sun goddess who guarded over a once prosperous eastern island nation.")
                    .append(" This classy, beautiful lady loves the aesthetics of man-on-man action.\"")
                    .toString(),
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = null,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5003,
                name = "Susanoo",
                jpName = "スサノオ",
                rarity = Rarity.SSR,
                element = Element.DARK,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5004,
                name = "Thor",
                jpName = "トール",
                rarity = Rarity.SSR,
                element = Element.THUNDER,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5005,
                name = "Acala",
                jpName = "不動明王",
                rarity = Rarity.SSR,
                element = Element.FIRE,
                type = CharacterType.OFFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5006,
                name = "Titania",
                jpName = "ティターニア",
                rarity = Rarity.SSR,
                element = Element.WIND,
                type = CharacterType.TRICKY,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5007,
                name = "Poseidon",
                jpName = "ティターニア",
                rarity = Rarity.SSR,
                element = Element.WATER,
                type = CharacterType.DEFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5008,
                name = "Raphael",
                jpName = "ラファエル",
                rarity = Rarity.SSR,
                element = Element.LIGHT,
                type = CharacterType.DEFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5009,
                name = "Raiko",
                jpName = "雷公",
                rarity = Rarity.SSR,
                element = Element.THUNDER,
                type = CharacterType.DEFENSE,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
        kamihimeRepository.updateKamihime(
            Kamihime(
                id = 5010,
                name = "Aphrodite",
                jpName = "アプロディーテ",
                rarity = Rarity.SSR,
                element = Element.WATER,
                type = CharacterType.HEALER,
                quote = null,
                obtainLocation = ObtainLocation.GACHA,
                releaseWeaponId = null,
                hpMin = null,
                hpMax = null,
                atkMin = null,
                atkMax = null,
                preAwakenId = null,
                postAwakenId = 42 /* temp */,
                additionalTags = emptyList()
            )
        )
    }
}
