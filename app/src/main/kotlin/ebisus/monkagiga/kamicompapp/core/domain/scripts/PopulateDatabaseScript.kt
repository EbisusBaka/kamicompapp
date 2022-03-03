package ebisus.monkagiga.kamicompapp.core.domain.scripts

import ebisus.monkagiga.kamicompapp.core.domain.entities.GenericMetadata
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityEffect
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityOutcome
import ebisus.monkagiga.kamicompapp.core.domain.entities.MetadataKey
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityColor
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityEffectCondition
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityOutcomeType
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityTarget
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import ebisus.monkagiga.kamicompapp.core.domain.repository.KamihimeRepository
import javax.inject.Inject

class PopulateDatabaseScript @Inject constructor(
    private val kamihimeRepository: KamihimeRepository
) {

    suspend fun populate() {
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
                abilities = listOf(
                    KamihimeAbility(
                        index = 0,
                        name = "Holy Ascension",
                        cooldownSeconds = 7,
                        abilityColor = AbilityColor.RED,
                        effect = KamihimeAbilityEffect(
                            condition = AbilityEffectCondition.NO_CONDITION,
                            abilityTarget = AbilityTarget.ALL_ENEMIES,
                            outcome = KamihimeAbilityOutcome(
                                outcomeType = AbilityOutcomeType.DEALS_DAMAGE,
                                metaData = GenericMetadata(
                                    MetadataKey.AMOUNT to 2.5
                                )
                            )
                        )
                    ),
                    KamihimeAbility(
                        index = 1,
                        name = "San Michel",
                        cooldownSeconds = 7,
                        abilityColor = AbilityColor.YELLOW,
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
                )
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
                atkMax = null
            )
        )
    }
}
