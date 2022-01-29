package ebisus.monkagiga.kamicompapp.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ebisus.monkagiga.kamicompapp.core.domain.Blowfish
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding
import ebisus.monkagiga.kamicompapp.databinding.ActivityMainBinding.inflate
import ebisus.monkagiga.kamicompapp.ext.viewBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(::inflate)

    @Inject
    lateinit var blowfish: Blowfish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toDecrypt = "4647c82eb23baa4c5e126b874817420d89d0e3b05b1be0d4"
        val toEncrypt = "battlecard_chara_5119_0"
        binding.textView.text = blowfish.decrypt(toDecrypt) + "\n" + blowfish.encrypt(toEncrypt)
    }

}
