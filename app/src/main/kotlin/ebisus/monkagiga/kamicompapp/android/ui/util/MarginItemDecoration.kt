package ebisus.monkagiga.kamicompapp.android.ui.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val spaceSize: Int, private val skipFirst: Boolean) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            val position = parent.getChildAdapterPosition(view)
            if (position == 0 && skipFirst) {
                // nothing
            } else if (position == 0 && !skipFirst) {
                top = spaceSize
                left = spaceSize
                right = spaceSize
                bottom = spaceSize
            } else if (position == 1 && skipFirst) {
                top = spaceSize
                left = spaceSize
                right = spaceSize
                bottom = spaceSize
            } else {
                left = spaceSize
                right = spaceSize
                bottom = spaceSize
            }

        }
    }
}
