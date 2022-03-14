package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ebisus.monkagiga.kamicompapp.android.ui.util.BasicDiffUtilCallback

class AbilityEffectAdapter(
    private val effectItemFactory: (ViewGroup) -> AbilityEffectViewHolder,
) : ListAdapter<AbilityEffectItem, RecyclerView.ViewHolder>(BasicDiffUtilCallback()) {

    var items: List<AbilityEffectItem> = emptyList()
        set(value) {
            field = value
            submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_EFFECT -> effectItemFactory(parent)
            else -> throw IllegalStateException("Unsupported viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AbilityEffectViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        else -> ITEM_EFFECT
    }

    companion object {

        private const val ITEM_EFFECT = 0
    }
}
