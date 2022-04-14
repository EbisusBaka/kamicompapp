package ebisus.monkagiga.kamicompapp.core.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ebisus.monkagiga.kamicompapp.core.domain.converters.AbilityColorConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.AbilityEffectConditionConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.AbilityTargetConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.CharacterTypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.ElementConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.FilterTagConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.FilterTagListConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.MetadataConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.ObtainLocationConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.RarityConverter
import ebisus.monkagiga.kamicompapp.core.domain.dao.EidolonDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityEffectDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityOutcomeDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeDao
import ebisus.monkagiga.kamicompapp.core.domain.entities.Eidolon
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityEffect
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbilityOutcome

@Database(
    entities = [
        Kamihime::class,
        KamihimeAbility::class,
        KamihimeAbilityEffect::class,
        KamihimeAbilityOutcome::class,
        Eidolon::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    RarityConverter::class,
    ElementConverter::class,
    CharacterTypeConverter::class,
    ObtainLocationConverter::class,
    AbilityEffectConditionConverter::class,
    AbilityTargetConverter::class,
    MetadataConverter::class,
    AbilityColorConverter::class,
    FilterTagConverter::class,
    FilterTagListConverter::class
)
abstract class Database : RoomDatabase() {

    abstract fun kamihimeDao(): KamihimeDao
    abstract fun kamihimeAbilityDao(): KamihimeAbilityDao
    abstract fun kamihimeAbilityEffectDao(): KamihimeAbilityEffectDao
    abstract fun kamihimeAbilityOutcomeDao(): KamihimeAbilityOutcomeDao
    abstract fun eidolonDao(): EidolonDao
}
