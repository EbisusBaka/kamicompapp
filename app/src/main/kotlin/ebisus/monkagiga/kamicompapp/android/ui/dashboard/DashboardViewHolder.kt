package ebisus.monkagiga.kamicompapp.android.ui.dashboard

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.databinding.ListitemDashboardBinding

class DashboardViewHolder(
    private val binding: ListitemDashboardBinding,
    private val itemClickedListener: (DashboardItem) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, itemClickedListener: (DashboardItem) -> Unit) : this(
        ListitemDashboardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        itemClickedListener
    )

    fun bind(item: DashboardItem) {
        loadImage(item)
        binding.image.setOnClickListener {
            itemClickedListener(item)
        }
        binding.title.text = itemView.context.getString(item.text)
    }

    private fun loadImage(
        item: DashboardItem
    ) {
        val drawable = CircularProgressDrawable(itemView.context)
        drawable.strokeWidth = 5f
        drawable.centerRadius = 30f
        @Suppress("DEPRECATION")
        drawable.setColorSchemeColors(ContextCompat.getColor(itemView.context, R.color.colorAccentPressed))
        drawable.start()
        Glide.with(binding.image)
            .load(item.imageUrlGenerator())
            .placeholder(drawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    itemView.post {
                        loadImage(item) // retry
                    }
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    updateBackgroundColor((resource as? BitmapDrawable))
                    return false
                }
            })
            .into(binding.image)
    }

    private fun updateBackgroundColor(bitmapDrawable: BitmapDrawable?) {
        bitmapDrawable ?: return
        val bitmap = bitmapDrawable.bitmap
        Palette.from(bitmap)
            .generate {
                it ?: return@generate
                val color = it.getDominantColor(ContextCompat.getColor(itemView.context, R.color.colorPrimary))
                binding.image.background = ColorDrawable(color)
            }
    }
}
