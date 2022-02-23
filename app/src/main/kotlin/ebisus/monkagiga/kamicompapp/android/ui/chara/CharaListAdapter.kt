package ebisus.monkagiga.kamicompapp.android.ui.chara

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ebisus.monkagiga.kamicompapp.android.ui.util.BasicDiffUtilCallback

class CharaListAdapter(
    private val itemFactory: (ViewGroup) -> CharaListViewHolder
) : ListAdapter<CharaListItem, CharaListViewHolder>(BasicDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharaListViewHolder {
        return itemFactory(parent)
    }

    override fun onBindViewHolder(holder: CharaListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
