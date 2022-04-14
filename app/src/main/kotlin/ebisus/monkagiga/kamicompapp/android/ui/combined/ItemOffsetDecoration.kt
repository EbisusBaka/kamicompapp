package ebisus.monkagiga.kamicompapp.android.ui.combined

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class CombinedItemOffsetDecoration(private val mItemOffset: Int) : RecyclerView.ItemDecoration() {
    constructor(
        context: Context,
        @DimenRes itemOffsetId: Int
    ) : this(context.resources.getDimensionPixelSize(itemOffsetId))

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val adapter = (parent.adapter as CombinedListAdapter)
        val item = adapter.currentList.getOrNull(position) ?: return
        when(item) {
            is CombinedListItem.CombinedListEidolonItem -> {
                outRect[mItemOffset, mItemOffset, mItemOffset] = mItemOffset
            }
            is CombinedListItem.CombinedListFiltersItem -> Unit
            is CombinedListItem.CombinedListKamihimeItem -> {
                outRect[mItemOffset, mItemOffset, mItemOffset] = mItemOffset
            }
            is CombinedListItem.CombinedListSoulItem -> {
                outRect[mItemOffset, mItemOffset, mItemOffset] = mItemOffset
            }
        }

    }
}
