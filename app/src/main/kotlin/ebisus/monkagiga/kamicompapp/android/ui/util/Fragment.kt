package ebisus.monkagiga.kamicompapp.android.ui.util

import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

fun FragmentActivity.navHostController(
    @IdRes resId: Int
): Lazy<NavController> = lazy(LazyThreadSafetyMode.NONE) {
    supportFragmentManager
        .findFragmentById(resId)
        .let { it as NavHostFragment }
        .navController
}

fun Fragment.navHostController(
    @IdRes resId: Int
): Lazy<NavController> = lazy(LazyThreadSafetyMode.NONE) {
    childFragmentManager
        .findFragmentById(resId)
        .let { it as NavHostFragment }
        .navController
}

fun <T : ViewBinding> Fragment.viewBinding(
    binding: (LayoutInflater) -> T
): Lazy<T> = ViewBindingRef(
    owner = { viewLifecycleOwner },
    inflater = { layoutInflater },
    binding = binding
)
