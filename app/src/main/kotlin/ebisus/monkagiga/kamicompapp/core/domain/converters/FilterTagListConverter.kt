package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.android.ui.combined.FilterTag

class FilterTagListConverter {

    @TypeConverter
    fun fromTagList(value: List<FilterTag>): String {
        return value.joinToString(",") { it.name }
    }

    @TypeConverter
    fun toTagList(value: String): List<FilterTag> {
        return value.split(',').filter { it.isNotBlank() }
            .map { FilterTag.valueOf(it) }
    }
}
