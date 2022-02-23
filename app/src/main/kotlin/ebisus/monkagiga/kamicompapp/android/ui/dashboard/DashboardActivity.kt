package ebisus.monkagiga.kamicompapp.android.ui.dashboard

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.databinding.ActivityDashboardBinding
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val binding: ActivityDashboardBinding by viewBinding(ActivityDashboardBinding::inflate)

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var adapter: DashboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
        initListener()

        viewModel.uiState
            .onEach { state ->
                binding.swipeRefresh.isRefreshing = false
                adapter.submitList(state.items)
            }
            .launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        adapter = DashboardAdapter(
            itemFactory = {
                DashboardViewHolder(it) { item ->
                    viewModel.onDashboardItemClicked(item)
                }
            })

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }

    private fun initListener() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.onSwipeRefresh()
        }
    }
}
