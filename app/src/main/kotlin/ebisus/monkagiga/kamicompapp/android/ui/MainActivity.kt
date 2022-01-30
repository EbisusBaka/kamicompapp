package ebisus.monkagiga.kamicompapp.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.core.domain.ImageResource
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding.inflate
import ebisus.monkagiga.kamicompapp.ext.dp
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(::inflate)

    @Inject
    lateinit var imageResource: ImageResource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = TestAdapter(
            itemFactory = {
                TestViewHolder(it, imageResource)
            })

        binding.recyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.addItemDecoration(ItemOffsetDecoration(8.dp))
        binding.recyclerView.adapter = adapter
        val items = ((5000..5220).toList() + (6000..6300).toList() + (7000..7220).toList()).map {
            TestItem(it)
        }
        adapter.submitList(items)
    }
}
