package com.programacionmultimedia.data.local

import com.programacionmultimedia.data.database.RoomModule
import com.programacionmultimedia.data.implementation.FilmRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.programacionmultimedia.domain.repository.FilmRepository

@InstallIn(SingletonComponent::class) //Busca la clase ya compilada de Activity
@Module(includes = [RoomModule::class]) //Como si instalaramos un plugin en una Activiy para poder usar objetos de este módulo.
abstract class DataModule {

    @Binds
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository
}