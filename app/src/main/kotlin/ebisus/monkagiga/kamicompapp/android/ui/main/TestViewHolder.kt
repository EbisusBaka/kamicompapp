package ebisus.monkagiga.kamicompapp.android.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.databinding.ListitemTestBinding

class TestViewHolder(
    private val binding: ListitemTestBinding,
    private val imageResourceProvider: ImageResourceProvider,
    private val itemClickedListener: (TestItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, imageResourceProvider: ImageResourceProvider, itemClickedListener: (TestItem) -> Unit) : this(
        ListitemTestBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        imageResourceProvider,
        itemClickedListener
    )

    fun bind(item: TestItem) {

        val drawable = CircularProgressDrawable(itemView.context)
        drawable.strokeWidth = 5f
        drawable.centerRadius = 30f
        @Suppress("DEPRECATION")
        drawable.setColorSchemeColors(ContextCompat.getColor(itemView.context, R.color.colorAccentPressed))
        drawable.start()
        Glide.with(binding.image)
            .load(imageResourceProvider.getPath("corecard", "chara", item.id, 0, "jpg"))
            .placeholder(drawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.image)

        binding.image.setOnClickListener {
            itemClickedListener(item)
        }
    }
}
