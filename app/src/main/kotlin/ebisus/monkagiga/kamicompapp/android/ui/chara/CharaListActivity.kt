package ebisus.monkagiga.kamicompapp.android.ui.chara

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.android.ui.kamihimedetails.CharaDetailsActivity
import ebisus.monkagiga.kamicompapp.android.ui.util.ItemOffsetDecoration
import ebisus.monkagiga.kamicompapp.core.domain.ImageResourceProvider
import ebisus.monkagiga.kamicompapp.databinding.ActivityCharaListBinding
import ebisus.monkagiga.kamicompapp.ext.dp
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CharaListActivity : AppCompatActivity() {

    private val binding: ActivityCharaListBinding by viewBinding(ActivityCharaListBinding::inflate)

    private val viewModel: CharaListViewModel by viewModels()

    @Inject
    lateinit var imageResourceProvider: ImageResourceProvider

    private lateinit var adapter: CharaListAdapter

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
        adapter = CharaListAdapter(
            itemFactory = {
                CharaListViewHolder(it, imageResourceProvider) { item ->
                    openPhotoZoomActivity(item)
                }
            })

        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.addItemDecoration(ItemOffsetDecoration(8.dp))
        binding.recyclerView.adapter = adapter
    }

    private fun openPhotoZoomActivity(item: CharaListItem) {
        val intent = Intent(this, CharaDetailsActivity::class.java)
        intent.putExtra(CharaDetailsActivity.EXTRA_ID, item.id)
        startActivity(intent)
    }
}
