package ebisus.monkagiga.kamicompapp.android.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.R
import ebisus.monkagiga.kamicompapp.android.ui.util.navHostController
import ebisus.monkagiga.kamicompapp.databinding.ActivitySingleBinding
import ebisus.monkagiga.kamicompapp.ext.viewBinding

@AndroidEntryPoint
class SingleActivity : AppCompatActivity() {

    private val binding: ActivitySingleBinding by viewBinding(ActivitySingleBinding::inflate)
    private val navController: NavController by navHostController(R.id.nav_host)
    private val viewModel: SingleActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val graph = navController.navInflater.inflate(R.navigation.nav_graph)
        navController.graph = graph

        viewModel.javaClass // invoke lazy
    }
}
