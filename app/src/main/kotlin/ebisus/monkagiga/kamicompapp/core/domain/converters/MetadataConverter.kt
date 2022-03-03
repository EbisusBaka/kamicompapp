package ebisus.monkagiga.kamicompapp.core.domain.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ebisus.monkagiga.kamicompapp.core.domain.entities.GenericMetadata
import ebisus.monkagiga.kamicompapp.core.domain.entities.MetadataKey

class MetadataConverter {

    @TypeConverter
    fun fromMetadata(value: GenericMetadata): String {
        val mapType = Map::class.java
        val metadataKeyType = MetadataKey::class.java
        val stringType = String::class.java
        return basicMoshi.adapter<Map<MetadataKey, String>>(Types.newParameterizedType(mapType, metadataKeyType, stringType))
            .toJson(value.values)
    }

    @TypeConverter
    fun toMetadata(value: String): GenericMetadata {
        val mapType = Map::class.java
        val metadataKeyType = MetadataKey::class.java
        val stringType = String::class.java
        return basicMoshi.adapter<Map<MetadataKey, String>>(Types.newParameterizedType(mapType, metadataKeyType, stringType))
            .fromJson(value)!!
            .let { GenericMetadata(it) }
    }

    companion object {

        private val basicMoshi = Moshi.Builder()
            .build()
    }
}
