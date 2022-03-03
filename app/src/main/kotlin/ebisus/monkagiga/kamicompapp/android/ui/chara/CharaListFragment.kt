package ebisus.monkagiga.kamicompapp.android.ui.chara

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.android.ui.util.ItemOffsetDecoration
import ebisus.monkagiga.kamicompapp.android.ui.util.viewBinding
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.databinding.FragmentCharaListBinding
import ebisus.monkagiga.kamicompapp.ext.dp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CharaListFragment : Fragment() {

    private val binding: FragmentCharaListBinding by viewBinding(FragmentCharaListBinding::inflate)

    private val viewModel: CharaListViewModel by viewModels()

    @Inject
    lateinit var imageResourceProvider: ImageResourceProvider

    private lateinit var adapter: CharaListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.uiState
            .onEach { state ->
                adapter.submitList(state.items)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.eventsFlow
            .onEach { event ->
                when (event) {
                    is CharaListViewModel.Event.NavigateToDetails -> {
                        findNavController().navigate(
                            CharaListFragmentDirections.actionCharaListToCharaDetails(
                                event.id
                            )
                        )
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setupRecyclerView() {
        adapter = CharaListAdapter(
            itemFactory = {
                CharaListViewHolder(it, imageResourceProvider) { item ->
                    viewModel.onCharacterClicked(item)
                }
            }
        )

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.addItemDecoration(ItemOffsetDecoration(8.dp))
        binding.recyclerView.adapter = adapter
    }
}
