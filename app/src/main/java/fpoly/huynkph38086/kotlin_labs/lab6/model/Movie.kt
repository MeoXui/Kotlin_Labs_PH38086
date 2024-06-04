package fpoly.huynkph38086.kotlin_labs.lab6.model

data class Movie(
    val title: String = "Phim Sieu Hay",
    val year: String = "3040",
    val posterUrl: String = "R.drawable.ic_launcher_foreground",
    val duration: String = "3000h20p33s",
    val releaseDate: String = "22/3/-100",
    val genre: String = "deo biet",
    val shotDescription: String = "uk, phim hay lam, xem di"
) {
    companion object {
        fun getSampleMovies() = listOf(Movie(), Movie(), Movie(), Movie(), Movie())
    }
}