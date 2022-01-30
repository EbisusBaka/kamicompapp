package ebisus.monkagiga.kamicompapp.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.core.domain.ImageResource
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding.inflate
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(::inflate)

    @Inject
    lateinit var imageResource: ImageResource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val imageUrl = imageResource.getPath("battlecard", "chara", 5119, 0, "png")
        Glide.with(binding.image)
            .load(imageUrl)
            .into(binding.image)
    }

}
