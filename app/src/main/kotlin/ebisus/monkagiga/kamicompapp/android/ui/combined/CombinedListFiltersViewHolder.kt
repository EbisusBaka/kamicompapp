package ebisus.monkagiga.kamicompapp.android.ui.combined

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.databinding.ListitemCombinedFiltersBinding

class CombinedListFiltersViewHolder(
    private val binding: ListitemCombinedFiltersBinding,
    private val filtersClickHelper: (FilterTagCategory, List<FilterTag>) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    constructor(parent: ViewGroup, filtersClickHelper: (FilterTagCategory, List<FilterTag>) -> Unit) : this(
        ListitemCombinedFiltersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        filtersClickHelper
    )

    fun bind(item: CombinedListItem.CombinedListFiltersItem) {
        binding.chipGroup.removeAllViews()
        item.filters.forEach {
            binding.chipGroup.addView(
                Chip(itemView.context).apply {
                    chipBackgroundColor = context.getColorStateList(R.color.chip_bg)
                    chipStrokeColor = context.getColorStateList(R.color.chip_stroke)
                    setTextColor(context.getColorStateList(R.color.chip_text))
                    text = it.text
                    tag = it
                    chipStrokeWidth = 2f
                    isClickable = true
                    isCheckable = true
                    isFocusable = true
                    isCheckedIconVisible = false
                    isChecked = it in item.enabledFilters
                    setOnClickListener {
                        val checkedFilters = binding.chipGroup.children.filterIsInstance<Chip>()
                            .filter { it.isChecked }
                            .map { it.tag }
                            .filterIsInstance<FilterTag>()
                            .toList()
                        item.enabledFilters = checkedFilters
                        filtersClickHelper(item.filterTagCategory, checkedFilters)
                    }
                }
            )
        }
    }
}
