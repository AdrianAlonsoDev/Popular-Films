package es.programacionmultimedia

import com.programacionmultimedia.data.DataModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module(includes = [DataModule::class])

class AppModule {



}