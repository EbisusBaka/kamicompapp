package ebisus.monkagiga.kamicompapp.android.ui.photozoom

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.databinding.ActivityPhotoZoomBinding
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PhotoZoomActivity : AppCompatActivity() {

    private val binding: ActivityPhotoZoomBinding by viewBinding(ActivityPhotoZoomBinding::inflate)

    private val viewModel: PhotoZoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, -1)
        viewModel.getData(id)

        viewModel.uiState
            .onEach { state ->
                val drawable = CircularProgressDrawable(this)
                drawable.strokeWidth = 5f
                drawable.centerRadius = 30f
                drawable.start()
                binding.image.maximumScale = 15f
                Glide.with(binding.image)
                    .load(state.imageUrl)
                    .placeholder(drawable)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(binding.image)
                if (state.data != null) {
                    binding.characterName.text = state.data.kamihime.name
                    binding.details.text = state.data.kamihime.quote
                } else {

                }

            }
            .launchIn(lifecycleScope)
    }

    companion object {

        const val EXTRA_ID = "EXTRA_ID"
    }
}
