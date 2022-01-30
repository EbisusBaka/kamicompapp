package ebisus.monkagiga.kamicompapp.core.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ebisus.monkagiga.kamicompapp.core.domain.Database
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun providesKamihimeDao(database: Database): KamihimeDao {
        return database.kamihimeDao()
    }

    @Provides
    @Singleton
    fun providesKamihimeAbilityDao(database: Database): KamihimeAbilityDao {
        return database.kamihimeAbilityDao()
    }
}
