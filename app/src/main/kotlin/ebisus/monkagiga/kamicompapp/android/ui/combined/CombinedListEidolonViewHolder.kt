package ebisus.monkagiga.kamicompapp.android.ui.combined

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.databinding.ListitemCharaBinding

class CombinedListEidolonViewHolder(
    private val binding: ListitemCharaBinding,
    private val imageResourceProvider: ImageResourceProvider,
    private val itemClickedListener: (CombinedListItem.CombinedListEidolonItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup,
        imageResourceProvider: ImageResourceProvider,
        itemClickedListener: (CombinedListItem.CombinedListEidolonItem) -> Unit
    ) : this(
        ListitemCharaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        imageResourceProvider,
        itemClickedListener
    )

    fun bind(item: CombinedListItem.CombinedListEidolonItem) {

        val drawable = CircularProgressDrawable(itemView.context)
        drawable.strokeWidth = 5f
        drawable.centerRadius = 30f
        @Suppress("DEPRECATION")
        drawable.setColorSchemeColors(ContextCompat.getColor(itemView.context, R.color.colorAccentPressed))
        drawable.start()
        val path = imageResourceProvider.getPath("corecard", "summon", item.eidolon.id, 0, "jpg")
        Glide.with(binding.image)
            .load(path)
            .placeholder(drawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.image)

        binding.image.setOnClickListener {
            itemClickedListener(item)
        }
    }
}
