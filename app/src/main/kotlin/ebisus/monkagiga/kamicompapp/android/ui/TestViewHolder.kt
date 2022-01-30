package ebisus.monkagiga.kamicompapp.android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ebisus.monkagiga.kamicompapp.core.domain.ImageResource
import ebisus.monkagiga.kamicompapp.databinding.ListitemTestBinding

class TestViewHolder(
    private val binding: ListitemTestBinding,
    private val imageResource: ImageResource
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, imageResource: ImageResource) : this(
        ListitemTestBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        imageResource
    )

    fun bind(item: TestItem) {

        Glide.with(binding.image)
            .load(imageResource.getPath("corecard", "chara", item.id, 0, "jpg"))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.image)
    }
}
