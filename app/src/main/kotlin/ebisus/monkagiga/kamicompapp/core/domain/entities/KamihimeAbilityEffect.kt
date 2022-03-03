package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityEffectCondition
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityTarget
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = KamihimeAbility::class,
            parentColumns = ["id"],
            childColumns = ["abilityId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class KamihimeAbilityEffect(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val condition: AbilityEffectCondition,
    val abilityTarget: AbilityTarget,
    @ColumnInfo
    var abilityId: Long? = null,
) : Parcelable {

    constructor(condition: AbilityEffectCondition, abilityTarget: AbilityTarget, outcomes: List<KamihimeAbilityOutcome>)
        : this(condition = condition, abilityTarget = abilityTarget) {
        this.outcomes = outcomes
    }

    constructor(condition: AbilityEffectCondition, abilityTarget: AbilityTarget, outcome: KamihimeAbilityOutcome)
        : this(condition = condition, abilityTarget = abilityTarget, outcomes = listOf(outcome))

    @IgnoredOnParcel @Ignore
    var outcomes: List<KamihimeAbilityOutcome> = emptyList()
}
