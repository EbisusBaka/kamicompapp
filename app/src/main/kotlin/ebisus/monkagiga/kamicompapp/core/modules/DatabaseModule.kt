package ebisus.monkagiga.kamicompapp.core.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ebisus.monkagiga.kamicompapp.core.domain.Database
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): Database = Room
        .databaseBuilder(
            context,
            Database::class.java,
            context.packageName
        )
        .build()
}
