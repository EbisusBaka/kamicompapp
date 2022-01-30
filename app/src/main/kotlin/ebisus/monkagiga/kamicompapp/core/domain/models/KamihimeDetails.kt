package ebisus.monkagiga.kamicompapp.core.domain.models

import android.os.Parcelable
import ebisus.monkagiga.kamicompapp.core.domain.entities.Kamihime
import ebisus.monkagiga.kamicompapp.core.domain.entities.KamihimeAbility
import kotlinx.parcelize.Parcelize

@Parcelize
data class KamihimeDetails(
    val kamihime: Kamihime,
    val abilities: List<KamihimeAbility>
) : Parcelable
