package fpoly.huynkph38086.kotlin_labs.lab7

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fpoly.huynkph38086.kotlin_labs.lab6.model.Movie
import fpoly.huynkph38086.kotlin_labs.lab8.MovieRequest
import fpoly.huynkph38086.kotlin_labs.lab8.RetrofitService
import kotlinx.coroutines.launch

class MovieViewModel  : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies
    var offlineMovies: ArrayList<Movie> = arrayListOf()
    var autoID: Int = 0

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.getListFilms()
                if (response.isSuccessful) {
                    _movies.postValue(response.body()?.map { it })
                } else {
                    _movies.postValue(emptyList())
                }
            } catch (e: Exception) {
                Log.e("TAG", "getMovies: " + e.message)
                _movies.postValue(emptyList())
            }
        }

        autoID = offlineMovies.size
    }

    fun getMovieById(filmId: String?): LiveData<Movie?> {
        val liveData = MutableLiveData<Movie?>()
        filmId?.let {
            viewModelScope.launch {
                try {
                    val response = RetrofitService().movieService.getFilmDetail(filmId)
                    if (response.isSuccessful) {
                        liveData.postValue(response.body())
                    } else {
                        liveData.postValue(null)
                    }
                } catch (e: Exception) {
                    liveData.postValue(null)
                }
            }
        }
        return liveData
    }

    fun offlineGetMovieByID(filmId: String?): Movie? {
        for (m in offlineMovies)
            if (filmId == m.id) return m
        return null
    }

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean> = _isSuccess

    fun addFilm(movieRequest: MovieRequest) {
        viewModelScope.launch {
            _isSuccess.value = try {
                val response = RetrofitService().movieService.addFilm(movieRequest)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status == 1) {
                            getMovies()
                            true
                        } else {
                            false
                        }
                    } ?: false
                } else {
                    false
                }
            } catch (e: Exception) {
                false
            }
        }
    }

    fun offlineAddFilm(m: Movie) {
        m.id = autoID.toString()
        offlineMovies.add(m)
        autoID++
    }

    fun updateMovie(movieRequest: MovieRequest) {
        viewModelScope.launch {
            _isSuccess.value = try {
                val response = RetrofitService().movieService.updateFilm(movieRequest)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status == 1) {
                            getMovies()
                            true
                        } else {
                            false
                        }
                    } ?: false
                } else {
                    false
                }
            } catch (e: Exception) {
                false
            }
        }
    }

    fun offlineUpdateMovie(m: Movie) {
        val i = offlineMovies.indexOf(offlineGetMovieByID(m.id))
        offlineMovies[i] = m
    }

    fun deleteMovieById(id: String) {
        viewModelScope.launch {
            _isSuccess.value = try {
                val response = RetrofitService().movieService.deleteFilm(id)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status == 1) {
                            getMovies()
                            true
                        } else {
                            false
                        }
                    } ?: false
                } else {
                    false
                }
            } catch (e: Exception) {
                false
            }
        }
    }

    fun offlineDeleteMovieById(id: String) {
        offlineMovies.remove(offlineGetMovieByID(id))
    }
}