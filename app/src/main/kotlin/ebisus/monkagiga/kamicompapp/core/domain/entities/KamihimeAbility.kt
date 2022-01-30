package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
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
    @PrimaryKey val id: Int,
    val name: String,
    val cooldownSeconds: Int,
    val index: Int,
    @ColumnInfo
    val kamihimeId: Int
) : Parcelable
