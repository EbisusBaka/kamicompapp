package ebisus.monkagiga.kamicompapp.core.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ebisus.monkagiga.kamicompapp.core.domain.Database
import ebisus.monkagiga.kamicompapp.core.domain.dao.EidolonDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityEffectDao
import ebisus.monkagiga.kamicompapp.core.domain.dao.KamihimeAbilityOutcomeDao
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

    @Provides
    @Singleton
    fun providesKamihimeAbilityEffectDao(database: Database): KamihimeAbilityEffectDao {
        return database.kamihimeAbilityEffectDao()
    }

    @Provides
    @Singleton
    fun providesKamihimeAbilityOutcomeDao(database: Database): KamihimeAbilityOutcomeDao {
        return database.kamihimeAbilityOutcomeDao()
    }

    @Provides
    @Singleton
    fun providesEidolonDao(database: Database): EidolonDao {
        return database.eidolonDao()
    }
}
