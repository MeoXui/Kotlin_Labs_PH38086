package fpoly.huynkph38086.kotlin_labs.lab8

data class MovieRequest(
    val filmId: Int? = null,
    val filmName: String,
    val duration: Int,
    val releaseDate: String,
    val genre: String,
    val national: String,
    val description: String,
    val image: String
)

data class StatusResponse(
    val status: Int,
    val message: String
)