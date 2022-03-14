package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.databinding.ListitemCharaDetailsImageBinding
import ebisus.monkagiga.kamicompapp.ext.dp

class CharaDetailsImageViewHolder(
    private val binding: ListitemCharaDetailsImageBinding,
    private val onSfwClickListener: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, onSfwClickListener: () -> Unit) : this(
        ListitemCharaDetailsImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onSfwClickListener
    )

    fun bind(item: CharaDetailsItem.Image) {

        val sfwButtonText = if (item.sfw) R.string.nsfw else R.string.sfw
        val sfwButtonColor = if (item.sfw) R.color.nsfw else R.color.sfw
        binding.sfwTextView.text = itemView.context.getString(sfwButtonText)
        binding.sfwButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, sfwButtonColor))
        val drawable = CircularProgressDrawable(itemView.context)
        drawable.strokeWidth = 4.dp.toFloat()
        drawable.centerRadius = 24.dp.toFloat()
        @Suppress("DEPRECATION")
        drawable.setColorSchemeColors(ContextCompat.getColor(itemView.context, R.color.colorAccentPressed))
        drawable.start()
        Glide.with(binding.image)
            .load(item.imageUrl)
            .placeholder(drawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.image)

        binding.sfwButton.setOnClickListener {
            onSfwClickListener()
        }
    }
}
