package catalog;

import java.util.HashSet;

public class Movie {
    final private String movieName;
    final private String releaseDate;
    final private double budget;
    final private String description;
    final private String genre;
    private HashSet<Actor> movieActors = new HashSet<>();
    private HashSet<Director> movieDirectors = new HashSet<>();

    public Movie(String nomeDoFilme, String releaseDate, double budget, String description, Genre genre) {
        this.movieName = nomeDoFilme;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.description = description;
        this.genre = genre.getGenreName();
    }

    public String getMovieName() {
        return movieName;
    }

    public String addPersonToMovie(Person person) {
        String personType = "";
        if (person instanceof Actor) {
            if (movieActors.contains((Actor) person)) {
                return "O ator já está associado ao filme";
            }
            personType = "ator";
            movieActors.add((Actor) person);
        }

        if (person instanceof Director) {
            if (movieDirectors.contains((Director) person)) {
                return "O diretor já está associado ao filme";
            }
            personType = "diretor";
            movieDirectors.add((Director) person);
        }

        return "O " + personType + " \"" + person.getName() + "\" foi adicionado ao filme \"" + this.getMovieName() + "\" com sucesso.";
    }

    @Override
    public String toString() {
        return "Nome do filme: " + movieName + "\n" +
                "Data de lançamento: " + releaseDate + "\n" +
                "Orçamento: " + budget + "\n" +
                "Descrição: " + description + "\n" +
                "Gênero: " + genre + "\n" +
                "Atores: " + movieActors + "\n" +
                "Diretores: " + movieDirectors;
    }
}