package ebisus.monkagiga.kamicompapp.android.ui.dashboard

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
import ebisus.monkagiga.kamicompapp.android.ui.util.viewBinding
import ebisus.monkagiga.kamicompapp.databinding.FragmentDashboardBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val binding: FragmentDashboardBinding by viewBinding(FragmentDashboardBinding::inflate)

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var adapter: DashboardAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        initListener()

        viewModel.uiState
            .onEach { state ->
                binding.swipeRefresh.isRefreshing = false
                adapter.submitList(state.items)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.eventsFlow
            .onEach { event ->
                when (event) {
                    DashboardViewModel.Event.OpenEidolonList -> Unit
                    DashboardViewModel.Event.OpenKamihimeList -> {
                        findNavController().navigate(
                            DashboardFragmentDirections.actionDashboardToCharaList()
                        )
                    }
                    DashboardViewModel.Event.OpenSoulList -> Unit
                    DashboardViewModel.Event.OpenWeaponList -> Unit
                }
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setupRecyclerView() {
        adapter = DashboardAdapter(
            itemFactory = {
                DashboardViewHolder(it) { item ->
                    viewModel.onDashboardItemClicked(item)
                }
            })

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }

    private fun initListener() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onSwipeRefresh()
        }
    }
}
