package edu.iesam.dam2.features.movies.data.remote

import edu.iesam.dam2.features.movies.domain.Movie

class MovieMockRemoteDataSource {

    private val movies = listOf(
    Movie("1", "Dune: Parte dos", "https://pics.filmaffinity.com/Dune_Parte_Dos-802143593-large.jpg","Sigue el viaje mítico de Paul Atreides mientras se une a Chani y los Fremen en una guerra de venganza contra los conspiradores que destruyeron a su familia. Al enfrentarse a una elección entre el amor de su vida y el destino del universo conocido, Paul se esfuerza por evitar un futuro terrible que solo él puede prever."),
    Movie("2", "Deadpool y Lobezno", "https://www.tuposter.com/pub/media/catalog/product/cache/71d04d62b2100522587d43c930e8a36b/d/e/deadpool_y_lobezno_2024_poster.png", "Un apático Wade Wilson se afana en la vida civil tras dejar atrás sus días como Deadpool, un mercenario moralmente flexible. Pero cuando su mundo natal se enfrenta a una amenaza existencial, Wade debe volver a vestirse a regañadientes con un Lobezno aún más reacio a ayudar."),
    Movie("3", "Godzilla y Kong: El nuevo imperio", "https://www.mubis.es/media/articles/33283/325993/nuevo-trailer-y-poster-de-godzilla-y-kong-el-nuevo-imperio-original.jpg", "Una aventura cinematográfica completamente nueva, que enfrentará al todopoderoso Kong y al temible Godzilla contra una colosal amenaza desconocida escondida dentro de nuestro mundo. La nueva y épica película profundizará en las historias de estos titanes, sus orígenes y los misterios de Isla Calavera y más allá, mientras descubre la batalla mítica que ayudó a forjar a estos seres extraordinarios y los unió a la humanidad para siempre.")
    )
    fun getMovies(): List<Movie>{
        return movies
    }

    fun getMovie(id: String) : Movie? {
        return movies.firstOrNull{ it.id == id}
    }
}