package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.android.ui.combined.FilterTag
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityColor

class FilterTagConverter {

    @TypeConverter
    fun fromTag(value: FilterTag): String {
        return value.name
    }

    @TypeConverter
    fun toTag(value: String): FilterTag {
        return FilterTag.valueOf(value)
    }
}
