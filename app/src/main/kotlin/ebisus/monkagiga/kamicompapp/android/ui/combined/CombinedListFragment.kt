package ebisus.monkagiga.kamicompapp.android.ui.combined

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
import ebisus.monkagiga.kamicompapp.databinding.FragmentCombinedListBinding
import ebisus.monkagiga.kamicompapp.ext.dp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CombinedListFragment : Fragment() {

    private val binding: FragmentCombinedListBinding by viewBinding(FragmentCombinedListBinding::inflate)

    private val viewModel: CombinedListViewModel by viewModels()

    @Inject
    lateinit var imageResourceProvider: ImageResourceProvider

    private lateinit var adapter: CombinedListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.uiState
            .onEach { state ->
                adapter.submitList(state.filterItems + state.filteredItems)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.eventsFlow
            .onEach { event ->
                when (event) {
                    is CombinedListViewModel.Event.NavigateToKamihimeDetails -> {
                        findNavController().navigate(
                            CombinedListFragmentDirections.actionCombinedListToCharaDetails(
                                event.id
                            )
                        )
                    }
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setupRecyclerView() {
        adapter = CombinedListAdapter(
            kamihimeItemFactory = {
                CombinedListKamihimeViewHolder(it, imageResourceProvider) { item ->
                    viewModel.onKamihimeClicked(item)
                }
            },
            eidolonItemFactory = {
                CombinedListEidolonViewHolder(it, imageResourceProvider) { item ->
                    viewModel.onEidolonClicked()
                }
            },
            soulItemFactory = {
                CombinedListSoulViewHolder(it, imageResourceProvider) { item ->
                    viewModel.onSoulClicked()
                }
            },
            filtersItemFactory = {
                CombinedListFiltersViewHolder(it) { category, filters ->
                    viewModel.onFiltersChanged(category, filters)
                }
            }
        )
        val gridLayoutManager = GridLayoutManager(requireContext(), 3)
        gridLayoutManager.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val items = adapter.currentList[position] ?: return 1
                return if(items is CombinedListItem.CombinedListFiltersItem) {
                    3
                } else {
                    1
                }
            }
        }
        binding.recyclerView.layoutManager = gridLayoutManager
        binding.recyclerView.addItemDecoration(CombinedItemOffsetDecoration(8.dp))
        binding.recyclerView.adapter = adapter
    }
}
