package ebisus.monkagiga.kamicompapp.android.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.android.ui.photozoom.PhotoZoomActivity
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding.inflate
import ebisus.monkagiga.kamicompapp.ext.dp
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(::inflate)

    private val viewModel: MainActivityViewModel by viewModels()

    @Inject
    lateinit var imageResourceProvider: ImageResourceProvider

    private lateinit var adapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel.uiState
            .onEach { state ->
                adapter.submitList(state.items)
            }
            .launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        adapter = TestAdapter(
            itemFactory = {
                TestViewHolder(it, imageResourceProvider) { item ->
                    openPhotoZoomActivity(item)
                }
            })

        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.addItemDecoration(ItemOffsetDecoration(8.dp))
        binding.recyclerView.adapter = adapter
    }

    private fun openPhotoZoomActivity(item: TestItem) {
        val intent = Intent(this, PhotoZoomActivity::class.java)
        intent.putExtra(PhotoZoomActivity.EXTRA_ID, item.id)
        startActivity(intent)
    }
}
