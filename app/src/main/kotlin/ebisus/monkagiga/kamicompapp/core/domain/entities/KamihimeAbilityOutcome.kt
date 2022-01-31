package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import ebisus.monkagiga.kamicompapp.core.domain.enums.AbilityOutcomeType
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = KamihimeAbilityEffect::class,
            parentColumns = ["id"],
            childColumns = ["effectId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class KamihimeAbilityOutcome(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val outcomeType: AbilityOutcomeType,
    val metaData: String,
    @ColumnInfo
    var effectId: Long? = null
) : Parcelable
