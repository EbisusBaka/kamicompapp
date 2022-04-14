package ebisus.monkagiga.kamicompapp.android.ui.combined

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ebisus.monkagiga.kamicompapp.android.ui.util.BasicDiffUtilCallback

class CombinedListAdapter(
    private val kamihimeItemFactory: (ViewGroup) -> CombinedListKamihimeViewHolder,
    private val eidolonItemFactory: (ViewGroup) -> CombinedListEidolonViewHolder,
    private val soulItemFactory: (ViewGroup) -> CombinedListSoulViewHolder,
    private val filtersItemFactory: (ViewGroup) -> CombinedListFiltersViewHolder
) : ListAdapter<CombinedListItem, RecyclerView.ViewHolder>(BasicDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_KAMIHIME -> kamihimeItemFactory(parent)
            VIEW_TYPE_EIDOLON -> eidolonItemFactory(parent)
            VIEW_TYPE_SOUL -> soulItemFactory(parent)
            VIEW_TYPE_FILTERS -> filtersItemFactory(parent)
            else -> throw IllegalStateException("Unsupported view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]
        when (holder) {
            is CombinedListKamihimeViewHolder -> holder.bind(item as CombinedListItem.CombinedListKamihimeItem)
            is CombinedListEidolonViewHolder -> holder.bind(item as CombinedListItem.CombinedListEidolonItem)
            is CombinedListSoulViewHolder -> holder.bind(item as CombinedListItem.CombinedListSoulItem)
            is CombinedListFiltersViewHolder -> holder.bind(item as CombinedListItem.CombinedListFiltersItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is CombinedListItem.CombinedListEidolonItem -> VIEW_TYPE_EIDOLON
            is CombinedListItem.CombinedListKamihimeItem -> VIEW_TYPE_KAMIHIME
            is CombinedListItem.CombinedListSoulItem -> VIEW_TYPE_SOUL
            is CombinedListItem.CombinedListFiltersItem -> VIEW_TYPE_FILTERS
        }
    }

    companion object {

        private const val VIEW_TYPE_FILTERS = -1
        private const val VIEW_TYPE_KAMIHIME = 0
        private const val VIEW_TYPE_EIDOLON = 1
        private const val VIEW_TYPE_SOUL = 2
    }
}
