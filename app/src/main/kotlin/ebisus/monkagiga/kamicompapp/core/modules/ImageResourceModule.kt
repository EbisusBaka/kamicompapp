package ebisus.monkagiga.kamicompapp.core.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ebisus.monkagiga.kamicompapp.core.domain.Blowfish
import ebisus.monkagiga.kamicompapp.core.domain.ImageResource

@Module
@InstallIn(SingletonComponent::class)
class ImageResourceModule {

    @Provides
    fun providesImageResource(blowfish: Blowfish): ImageResource = ImageResource(blowfish)
}
