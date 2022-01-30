package ebisus.monkagiga.kamicompapp.core.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = KamihimeAbility::class,
            parentColumns = ["id"],
            childColumns = ["kamihimeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class AbilityEffect(
    @PrimaryKey val id: Int,
    val name: String,
    val cooldownSeconds: Int,
    @ColumnInfo
    val kamihimeId: Int

)
