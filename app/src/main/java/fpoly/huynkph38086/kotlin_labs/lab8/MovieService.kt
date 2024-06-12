package fpoly.huynkph38086.kotlin_labs.lab8

import fpoly.huynkph38086.kotlin_labs.lab6.model.Movie
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MovieService {
    @GET("list-film.php")
    suspend fun getListFilms(): Response<List<Movie>>
    @GET("film-detail.php")
    suspend fun getFilmDetail(@Query("id") id: String): Response<Movie>
    @POST("add-film.php")
    suspend fun addFilm(@Body filmRequest: MovieRequest): Response<StatusResponse>
    @POST("update-film.php")
    suspend fun updateFilm(@Body filmRequest: MovieRequest): Response<StatusResponse>
    @DELETE("delete-film.php")
    suspend fun deleteFilm(@Query("id") id: String): Response<StatusResponse>

    @S
}