package ebisus.monkagiga.kamicompapp.android.ui.util

import android.view.LayoutInflater
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding

internal class ViewBindingRef<T : ViewBinding>(
    private val binding: (LayoutInflater) -> T,
    private val owner: () -> LifecycleOwner,
    private val inflater: () -> LayoutInflater
) : Lazy<T> {

    private var cached: T? = null

    override val value: T
        get() = cached ?: run {
            val lifecycleOwner: LifecycleOwner = owner()
            lifecycleOwner.lifecycle.addObserver(
                object : DefaultLifecycleObserver {
                    override fun onDestroy(owner: LifecycleOwner) {
                        lifecycleOwner.lifecycle.removeObserver(this)
                        cached = null
                    }
                }
            )

            val layoutInflater: LayoutInflater = inflater()
            val binding: T = binding(layoutInflater)

            cached = binding
            return binding
        }

    override fun isInitialized(): Boolean {
        return cached != null
    }
}
