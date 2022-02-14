package es.programacionmultimedia.detail

data class FilmDataView(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String?,
    val rating: Double,
    val director: String?,
    val videoId: String?
)