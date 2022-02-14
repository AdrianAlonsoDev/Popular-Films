package com.programacionmultimedia.data.database

import androidx.room.*

@Dao
interface FilmDao {

    @Query("SELECT * FROM FilmEntity")
    suspend fun getFilmList(): List<FilmEntity>

    @Query("SELECT * FROM FilmEntity WHERE id LIKE :filmID")
    suspend fun getFilm(filmID: Int): FilmEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films: List<FilmEntity>)

    @Delete
    suspend fun deleteFilm(Film: FilmEntity)

    @Query("DELETE from FilmEntity")
    suspend fun deleteAll()
}