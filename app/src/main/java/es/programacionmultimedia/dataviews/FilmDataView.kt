package es.programacionmultimedia.dataviews

data class FilmDataView(
    val title: String,
    val description: String,
    val imageUrl: String?,
    val rating: Double,
    val director: String?
)