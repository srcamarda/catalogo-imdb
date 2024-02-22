package catalogController;

import catalog.Genre;
import catalog.Movie;
import utils.Validator;

import java.util.HashSet;

public class MovieController {
    private HashSet<Movie> registeredMovies = new HashSet<>();

    public String registerMovie(String movieName, String releaseDate, int movieBudget, String movieDescription, Genre movieGenre) {
        if (Validator.nullOrEmpty(movieName, releaseDate, String.valueOf(movieBudget), movieDescription)) {
            return "Não foi possível concluir o cadastro do filme. Verifique as entradas e tente novamente.";
        }

        if (!Validator.budgetValidator(movieBudget)) {
            return "Orçamento inválido, tente novamente";
        }

        if (searchMovie(movieName) != null) {
            return "Filme já está cadastrado no sistema";
        }

        Movie newMovie = new Movie(movieName, releaseDate, movieBudget, movieDescription, movieGenre);
        registeredMovies.add(newMovie);
        return "Filme cadastrado com sucesso!";
    }

    public Movie searchMovie(String movieNameToFind) {
        for (Movie movie : registeredMovies) {
            String movieName = movie.getMovieName();
            if (movieName.equalsIgnoreCase(movieNameToFind)) {
                return movie;
            }
        }
        return null;
    }

    public String getRegisteredMovies() {
        int counter = 0;

        if (registeredMovies.isEmpty())
            return "Nenhum filme cadastrado!";

        StringBuilder registeredMoviesStr = new StringBuilder("[");
        for (Movie movie : registeredMovies) {
            registeredMoviesStr.append(movie.getMovieName());
            if (++counter < registeredMovies.size()) {
                registeredMoviesStr.append(",");
            }
        }
        registeredMoviesStr.append("]");
        return registeredMoviesStr.toString();
    }
}
