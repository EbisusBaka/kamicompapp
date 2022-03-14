package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityColor
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Kamihime::class,
            parentColumns = ["id"],
            childColumns = ["kamihimeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class KamihimeAbility(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val index: Int,
    val name: String,
    val cooldownTurns: Int,
    val abilityColor: AbilityColor,
    val abilityIconId: Long,
    @ColumnInfo
    var kamihimeId: Long? = null,
) : Parcelable {

    constructor(index: Int, name: String, cooldownSeconds: Int, abilityColor: AbilityColor, abilityIconId: Long, effects: List<KamihimeAbilityEffect>) : this(
        index = index,
        name = name,
        cooldownTurns = cooldownSeconds,
        abilityColor = abilityColor,
        abilityIconId = abilityIconId
    ) {
        this.effects = effects
    }

    constructor(index: Int, name: String, cooldownSeconds: Int, abilityColor: AbilityColor, abilityIconId: Long, effect: KamihimeAbilityEffect) : this(
        index = index,
        name = name,
        cooldownSeconds = cooldownSeconds,
        abilityColor = abilityColor,
        abilityIconId = abilityIconId,
        effects = listOf(effect)
    )

    @IgnoredOnParcel @Ignore
    var effects: List<KamihimeAbilityEffect> = emptyList()
}
