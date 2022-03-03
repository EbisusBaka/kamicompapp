package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityColor

class AbilityColorConverter {

    @TypeConverter
    fun fromColor(value: AbilityColor): String {
        return value.name
    }

    @TypeConverter
    fun toColor(value: String): AbilityColor {
        return AbilityColor.valueOf(value)
    }
}
