package es.programacionmultimedia.domain.model

/*
 * Model/entity class of a film, with it's own data fields
 * Class is data class type, because otherwise it could fail when comparing objects.
 */
data class Film(
    val id: Int,
    val title: String,
    val genre: String,
    val description: String,
    val director: String?,
    val rating: Double,
    val imageUrl: String?,
    val trailerId: String?
)