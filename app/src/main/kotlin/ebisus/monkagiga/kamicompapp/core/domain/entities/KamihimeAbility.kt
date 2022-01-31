package ebisus.monkagiga.kamicompapp.core.domain.entities

import android.os.Parcelable
import androidx.room.*
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
    val cooldownSeconds: Int,
    @ColumnInfo
    var kamihimeId: Long? = null,
) : Parcelable {

    @IgnoredOnParcel @Ignore
    var effects: List<KamihimeAbilityEffect> = emptyList()
}
