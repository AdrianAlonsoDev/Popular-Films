package es.programacionmultimedia.domain.model

/*
 * Model/entity class of a film, with it's own data fields
 * Class is data class type, because otherwise it could fail when comparing objects.
 */
data class Film(
    val title: String,
    val imageUrl: String,
    val rating: Double,
    val director: String
    )