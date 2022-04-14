package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import ebisus.monkagiga.kamicompapp.android.ui.combined.FilterTag
import ebisus.monkagiga.kamicompapp.core.domain.enums.CharacterType
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.core.domain.enums.ObtainLocation
import ebisus.monkagiga.kamicompapp.core.domain.enums.Rarity
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Kamihime(
    @PrimaryKey val id: Long,
    val name: String,
    val jpName: String,
    val rarity: Rarity,
    val element: Element,
    val type: CharacterType,
    val quote: String?,
    val obtainLocation: ObtainLocation?,
    val releaseWeaponId: Long?,
    val hpMin: Int?,
    val hpMax: Int?,
    val atkMin: Int?,
    val atkMax: Int?,
    val preAwakenId: Long?,
    val postAwakenId: Long?,
    val additionalTags: List<FilterTag>,
) : Parcelable {

    constructor(
        id: Long,
        name: String,
        jpName: String,
        rarity: Rarity,
        element: Element,
        type: CharacterType,
        quote: String?,
        obtainLocation: ObtainLocation?,
        releaseWeaponId: Long?,
        hpMin: Int?,
        hpMax: Int?,
        atkMin: Int?,
        atkMax: Int?,
        preAwakenId: Long?,
        postAwakenId: Long?,
        additionalTags: List<FilterTag>,
        abilities: List<KamihimeAbility>
    ) : this(
        id = id,
        name = name,
        jpName = jpName,
        rarity = rarity,
        element = element,
        type = type,
        quote = quote,
        obtainLocation = obtainLocation,
        releaseWeaponId = releaseWeaponId,
        hpMin = hpMin,
        hpMax = hpMax,
        atkMin = atkMin,
        atkMax = atkMax,
        preAwakenId = preAwakenId,
        postAwakenId = postAwakenId,
        additionalTags = additionalTags
    ) {
        this.abilities = abilities
    }

    @IgnoredOnParcel @Ignore
    var abilities: List<KamihimeAbility> = emptyList()
}
