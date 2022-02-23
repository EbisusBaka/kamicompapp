package ebisus.monkagiga.kamicompapp.android.ui.dashboard

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ebisus.monkagiga.kamicompapp.android.ui.util.BasicDiffUtilCallback

class DashboardAdapter(
    private val itemFactory: (ViewGroup) -> DashboardViewHolder
) : ListAdapter<DashboardItem, DashboardViewHolder>(BasicDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return itemFactory(parent)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
