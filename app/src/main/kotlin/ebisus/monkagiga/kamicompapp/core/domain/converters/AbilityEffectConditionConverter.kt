package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityEffectCondition

class AbilityEffectConditionConverter {

    @TypeConverter
    fun fromAbilityEffectCondition(value: AbilityEffectCondition): String {
        return value.name
    }

    @TypeConverter
    fun toAbilityEffectCondition(value: String): AbilityEffectCondition {
        return AbilityEffectCondition.valueOf(value)
    }
}
