package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element

class ElementConverter {

    @TypeConverter
    fun fromElement(value: Element): String {
        return value.name
    }

    @TypeConverter
    fun toElement(value: String): Element {
        return Element.valueOf(value)
    }
}
