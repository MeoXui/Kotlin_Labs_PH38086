package fpoly.huynkph38086.kotlin_labs.lab6.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("filmId") var id: String = "0",
    @SerializedName("filmName") var filmName: String = "Phim Sieu hay",
    @SerializedName("duration") var duration: String = "23",
    @SerializedName("releaseDate") var releaseDate: String = "19/2/3401",
    @SerializedName("genre") var genre: String = "Vũ trụ",
    @SerializedName("national") var national: String = "Sao Hỏa",
    @SerializedName("description") var description: String = "Hay lắm xem đi",
    @SerializedName("image") var image: String = "/null",
) {
    companion object {
        fun getSampleMovies() = listOf(Movie("0"), Movie("1"), Movie("2"), Movie("3"), Movie("4"))
    }
}