package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityTarget

class AbilityTargetConverter {

    @TypeConverter
    fun fromAbilityTarget(value: AbilityTarget): String {
        return value.name
    }

    @TypeConverter
    fun toAbilityTarget(value: String): AbilityTarget {
        return AbilityTarget.valueOf(value)
    }
}
