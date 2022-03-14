package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.text.Spanned
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.RecyclerView
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.core.domain.enums.Element
import ebisus.monkagiga.kamicompapp.databinding.ListItemOutcomeDealsDamageBinding
import ebisus.monkagiga.kamicompapp.ext.dp

class OutcomeDealsDamageViewHolder(
    private val binding: ListItemOutcomeDealsDamageBinding,
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup) : this(
        ListItemOutcomeDealsDamageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    fun bind(item: EffectOutcomeItem.DealsDamage) {
        binding.textView.text = buildSpannedString {
            append("Deals ")
            bold {
                append("x${item.amount}")
            }
            val iconId = when (item.element) {
                Element.FIRE -> R.drawable.ic_fire
                Element.WATER -> R.drawable.ic_water
                Element.WIND -> R.drawable.ic_wind
                Element.THUNDER -> R.drawable.ic_thunder
                Element.LIGHT -> R.drawable.ic_light
                Element.DARK -> R.drawable.ic_dark
                Element.PHANTOM -> R.drawable.ic_phantom
                Element.NO_ELEMENT -> null
            }
            if (iconId != null) {
                val drawable = ContextCompat.getDrawable(itemView.context, iconId)!!
                val textSize = (binding.textView.textSize.toInt()) + 4.dp
                val scale = textSize.toFloat() / drawable.intrinsicHeight
                drawable.setBounds(0, 0, (drawable.intrinsicWidth * scale).toInt(), textSize);
                val icon = ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM)
                append(" -")
                setSpan(icon, length - 1, length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            }
            append(" damage")
        }
    }
}
