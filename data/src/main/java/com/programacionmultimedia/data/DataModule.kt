package com.programacionmultimedia.data

import com.programacionmultimedia.data.implementation.FilmRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import es.programacionmultimedia.domain.repository.FilmRepository

@InstallIn(ActivityComponent::class) //Busca la clase ya compilada de Activity
@Module //Como si instalaramos un plugin en una Activiy para poder usar objetos de este módulo.
abstract class DataModule {

    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}