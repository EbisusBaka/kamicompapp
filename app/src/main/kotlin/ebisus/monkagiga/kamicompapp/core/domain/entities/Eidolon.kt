package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ebisus.monkagiga.kamicompapp.android.ui.combined.FilterTag
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Eidolon(
    @PrimaryKey val id: Long,
    val name: String,
    val jpName: String,
    val rarity: Rarity,
    val element: Element,
    val obtainLocation: ObtainLocation?,
    val hpMin: Int?,
    val hpMax: Int?,
    val atkMin: Int?,
    val atkMax: Int?,
    val additionalTags: List<FilterTag>,
) : Parcelable
