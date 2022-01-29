package ebisus.monkagiga.kamicompapp.core.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ebisus.monkagiga.kamicompapp.core.domain.Blowfish

@Module
@InstallIn(SingletonComponent::class)
class BlowfishModule {

    private val key = "WD24kYA7UaiHMpNq6BQ"

    @Provides
    fun providesBlowfish(): Blowfish = Blowfish(key)
}
