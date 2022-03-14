package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.android.ui.util.MarginItemDecoration
import ebisus.monkagiga.kamicompapp.android.ui.util.viewBinding
import ebisus.monkagiga.kamicompapp.databinding.FragmentCharaDetailsBinding
import ebisus.monkagiga.kamicompapp.ext.dp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CharaDetailsFragment : Fragment() {

    private val binding: FragmentCharaDetailsBinding by viewBinding(FragmentCharaDetailsBinding::inflate)

    private val viewModel: CharaDetailsViewModel by viewModels()

    private lateinit var adapter: CharaDetailsAdapter

    @Inject
    lateinit var abilityEffectsItemTransformer: AbilityEffectsItemTransformer

    @Inject
    lateinit var effectOutcomeItemTransformer: EffectOutcomeItemTransformer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        viewModel.getData(requireArguments().getLong("kamihimeId", -1))

        viewModel.uiState
            .onEach { state ->
                loadDetails(state)
                adapter.items = state.items
            }
            .launchIn(lifecycleScope)
    }

    private fun initRecycler() {
        adapter = CharaDetailsAdapter(
            imageItemFactory = {
                CharaDetailsImageViewHolder(
                    parent = it,
                    onSfwClickListener = viewModel::onSfwButtonClicked
                )
            },
            abilityDetailsItemFactory = {
                CharaDetailsAbilityViewHolder(
                    parent = it,
                    abilityEffectsItemTransformer = abilityEffectsItemTransformer,
                    effectOutcomeItemTransformer = effectOutcomeItemTransformer
                )
            }
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MarginItemDecoration(8.dp, skipFirst = true))
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
}
