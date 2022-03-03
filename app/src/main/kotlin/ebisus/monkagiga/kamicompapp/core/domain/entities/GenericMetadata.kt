package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenericMetadata(val values: Map<MetadataKey, String>) : Parcelable {

    constructor(vararg values: Pair<MetadataKey, Any>) : this(values.associate { it.first to it.second.toString() })
}
