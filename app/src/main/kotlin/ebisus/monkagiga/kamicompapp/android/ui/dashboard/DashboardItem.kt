package ebisus.monkagiga.kamicompapp.android.ui.dashboard

import androidx.annotation.StringRes

data class DashboardItem(
    val dashboardItemType: DashboardItemType,
    val imageUrlGenerator: (() -> String)?,
    @StringRes val text: Int
)
