package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ebisus.monkagiga.kamicompapp.android.ui.util.BasicDiffUtilCallback

class EffectOutcomeAdapter(
    private val outcomeDealsDamageFactory: (ViewGroup) -> OutcomeDealsDamageViewHolder,
) : ListAdapter<EffectOutcomeItem, RecyclerView.ViewHolder>(BasicDiffUtilCallback()) {

    var items: List<EffectOutcomeItem> = emptyList()
        set(value) {
            field = value
            submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_DEALS_DAMAGE -> outcomeDealsDamageFactory(parent)
            else -> throw IllegalStateException("Unsupported viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OutcomeDealsDamageViewHolder -> holder.bind(items[position] as EffectOutcomeItem.DealsDamage)
        }
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is EffectOutcomeItem.DealsDamage -> ITEM_DEALS_DAMAGE
    }

    companion object {

        private const val ITEM_DEALS_DAMAGE = 0
    }
}
