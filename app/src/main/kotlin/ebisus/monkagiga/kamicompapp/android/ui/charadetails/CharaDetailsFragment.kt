package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.android.ui.util.viewBinding
import ebisus.monkagiga.kamicompapp.databinding.FragmentCharaDetailsBinding
import ebisus.monkagiga.kamicompapp.ext.dp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class CharaDetailsFragment : Fragment() {

    private val binding: FragmentCharaDetailsBinding by viewBinding(FragmentCharaDetailsBinding::inflate)

    private val viewModel: CharaDetailsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()

        viewModel.getData(requireArguments().getLong("kamihimeId", -1))

        viewModel.uiState
            .onEach { state ->
                loadMainImage(state)
                loadDetails(state)
            }
            .launchIn(lifecycleScope)
    }

    private fun initListener() {
        binding.sfwButton.setOnClickListener {
            viewModel.onSfwButtonClicked()
        }
    }

    private fun loadDetails(
        state: CharaDetailsViewModel.State
    ) {
        state.data ?: return
        binding.title.text = state.data.kamihime.name
        binding.enPageButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://kamihime-project.fandom.com/wiki/${state.data.kamihime.name}"))
            startActivity(browserIntent)
        }
        binding.jpPageButton.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://xn--hckqz0e9cygq471ahu9b.xn--wiki-4i9hs14f.com/index.php?${state.data.kamihime.jpName}")
            )
            startActivity(browserIntent)
        }
    }

    private fun loadMainImage(state: CharaDetailsViewModel.State) {
        val sfwButtonText = if (state.sfw) R.string.nsfw else R.string.sfw
        val sfwButtonColor = if (state.sfw) R.color.nsfw else R.color.sfw
        binding.sfwTextView.text = getString(sfwButtonText)
        binding.sfwButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(requireContext(), sfwButtonColor))
        val drawable = CircularProgressDrawable(requireContext())
        drawable.strokeWidth = 4.dp.toFloat()
        drawable.centerRadius = 24.dp.toFloat()
        @Suppress("DEPRECATION")
        drawable.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorAccentPressed))
        drawable.start()
        Glide.with(binding.image)
            .load(state.imageUrl)
            .placeholder(drawable)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.image)
    }

    companion object {

        const val EXTRA_ID = "EXTRA_ID"
    }
}
