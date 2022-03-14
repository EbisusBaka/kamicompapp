package ebisus.monkagiga.kamicompapp.android.ui.charadetails

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ebisus.monkagiga.kamicompapp.android.ui.util.BasicDiffUtilCallback

class CharaDetailsAdapter(
    private val imageItemFactory: (ViewGroup) -> CharaDetailsImageViewHolder,
    private val abilityDetailsItemFactory: (ViewGroup) -> CharaDetailsAbilityViewHolder
) : ListAdapter<CharaDetailsItem, RecyclerView.ViewHolder>(BasicDiffUtilCallback()) {

    var items: List<CharaDetailsItem> = emptyList()
        set(value) {
            field = value
            submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_IMAGE -> imageItemFactory(parent)
            ITEM_ABILITY -> abilityDetailsItemFactory(parent)
            else -> throw IllegalStateException("Unsupported viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharaDetailsImageViewHolder -> holder.bind(items[position] as CharaDetailsItem.Image)
            is CharaDetailsAbilityViewHolder -> holder.bind(items[position] as CharaDetailsItem.Ability)
        }
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is CharaDetailsItem.Image -> ITEM_IMAGE
        is CharaDetailsItem.Ability -> ITEM_ABILITY
    }

    companion object {

        private const val ITEM_IMAGE = 0
        private const val ITEM_ABILITY = 1
    }
}
