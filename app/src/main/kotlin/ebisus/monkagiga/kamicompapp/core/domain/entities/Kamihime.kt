package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Kamihime(
    @PrimaryKey val id: Int,
    val name: String,
    val jpName: String,
    val rarity: Rarity,
    val element: Element,
    val type: CharacterType,
    val quote: String?,
    val obtainLocation: ObtainLocation?,
    val releaseWeaponId: Int?,
    val hpMin: Int?,
    val hpMax: Int?,
    val atkMin: Int?,
    val atkMax: Int?,
) : Parcelable
