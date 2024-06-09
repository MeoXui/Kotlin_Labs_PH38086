package fpoly.huynkph38086.kotlin_labs.lab6.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("filmId") val id: String = "0",
    @SerializedName("filmName") val filmName: String = "null",
    @SerializedName("duration") val duration: String = "nan:nan:nan",
    @SerializedName("releaseDate") val releaseDate: String = "nan/nan/nan",
    @SerializedName("genre") val genre: String = "nan",
    @SerializedName("national") val national: String = "null",
    @SerializedName("description") val description: String = "",
    @SerializedName("image") val image: String = "/null",
) {
    companion object {
        fun getSampleMovies() = listOf(Movie(), Movie(), Movie(), Movie(), Movie())
    }
}