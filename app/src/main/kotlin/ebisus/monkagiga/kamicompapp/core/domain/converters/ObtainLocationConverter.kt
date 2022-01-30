package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation

class ObtainLocationConverter {

    @TypeConverter
    fun fromObtainLocation(value: ObtainLocation): String {
        return value.name
    }

    @TypeConverter
    fun toObtainLocation(value: String): ObtainLocation {
        return ObtainLocation.valueOf(value)
    }
}
