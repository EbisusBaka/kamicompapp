package ebisus.monkagiga.kamicompapp.android.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class TestAdapter(
    private val itemFactory: (ViewGroup) -> TestViewHolder
) : ListAdapter<TestItem, TestViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return itemFactory(parent)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TestItem>() {
            override fun areItemsTheSame(oldItem: TestItem, newItem: TestItem): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: TestItem, newItem: TestItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
