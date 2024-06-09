package fpoly.huynkph38086.kotlin_labs.lab8

import fpoly.huynkph38086.kotlin_labs.lab6.model.Movie

fun MovieFormData.toMovie(): Movie {
    val filmIdInt = try {
        this.id?.toIntOrNull()
    } catch (e: NumberFormatException) {
        null
    }
    val durationInt = try {
        this.duration.toInt()
    } catch (e: NumberFormatException) {
        0
    }
    return Movie(
        id = filmIdInt.toString(),
        filmName = this.filmName,
        duration = durationInt.toString(),
        releaseDate = this.releaseDate,
        genre = this.genre,
        national = this.national,
        description = this.description,
        image = this.imageUrl
    )
}

fun MovieFormData.toMovieRequest(): MovieRequest {
    val filmIdInt = try {
        this.id?.toIntOrNull()
    } catch (e: NumberFormatException) {
        null
    }
    val durationInt = try {
        this.duration.toInt()
    } catch (e: NumberFormatException) {
        0
    }
    return MovieRequest(
        filmId = filmIdInt,
        filmName = this.filmName,
        duration = durationInt,
        releaseDate = this.releaseDate,
        genre = this.genre,
        national = this.national,
        description = this.description,
        image = this.imageUrl
    )
}

fun Movie?.toMovieFormData() = this?.let {
    MovieFormData(
        this.id,
        this.filmName,
        this.duration,
        this.releaseDate,
        this.genre,
        this.national,
        this.description,
        this.image
    )
}