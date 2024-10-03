package edu.iesam.dam2.features.movies.data.remote

import edu.iesam.dam2.features.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies = listOf(
    Movie("1", "title1", "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg"),
    Movie("2", "title2", "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg"),
    Movie("3", "title3", "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg"),
    Movie(title = "title4", poster = "https://es.web.img2.acsta.net/r_1920_1080/img/d4/f5/d4f5d8388a8f5a89126994ca86f7cd96.jpg", id = "4")
    )
    fun getMovies(): List<Movie>{
        return movies
    }

    fun getMovie(id: String) : Movie? {
        return movies.firstOrNull{ it.id == id}
    }
}