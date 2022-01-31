package es.programacionmultimedia.detail

data class FilmDataView(
    val title: String,
    val description: String,
    val imageUrl: String?,
    val rating: Double,
    val director: String?
)