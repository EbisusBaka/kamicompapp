package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType

class CharacterTypeConverter {

    @TypeConverter
    fun fromCharacterType(value: CharacterType): String {
        return value.name
    }

    @TypeConverter
    fun toCharacterType(value: String): CharacterType {
        return CharacterType.valueOf(value)
    }
}
