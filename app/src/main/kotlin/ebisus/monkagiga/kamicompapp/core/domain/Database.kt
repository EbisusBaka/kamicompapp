package ebisus.monkagiga.kamicompapp.core.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ebisus.monkagiga.kamicompapp.core.domain.converters.CharacterTypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.ElementConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.ObtainLocationConverter
import ebisus.monkagiga.kamicompapp.core.domain.converters.RarityConverter
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeDao
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility

@Database(
    entities = [
        Kamihime::class,
        KamihimeAbility::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    RarityConverter::class,
    ElementConverter::class,
    CharacterTypeConverter::class,
    ObtainLocationConverter::class
)
abstract class Database : RoomDatabase() {

    abstract fun kamihimeDao(): KamihimeDao
    abstract fun kamihimeAbilityDao(): KamihimeAbilityDao
}
