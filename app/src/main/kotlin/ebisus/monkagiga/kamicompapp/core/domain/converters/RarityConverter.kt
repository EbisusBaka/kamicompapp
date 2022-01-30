package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity

class RarityConverter {

    @TypeConverter
    fun fromRarity(value: Rarity): String {
        return value.name
    }

    @TypeConverter
    fun toRarity(value: String): Rarity {
        return Rarity.valueOf(value)
    }
}
