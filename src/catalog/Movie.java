package catalog;

import java.util.ArrayList;

public class Movie {
    final private String movieName;
    final private String releaseDate;
    final private double budget;
    final private String description;
    final private String genre;
    private ArrayList<Actor> movieActors = new ArrayList<>();
    private ArrayList<Director> movieDirectors = new ArrayList<>();

    public Movie(String nomeDoFilme, String releaseDate, double budget, String description, Genre genre) {
        this.movieName = nomeDoFilme;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.description = description;
        this.genre = genre.toString().toLowerCase();
    }

    public String getMovieName() {
        return movieName;
    }

    public String addPersonToMovie(Person person) {
        if (person instanceof Actor)
            movieActors.add((Actor) person);

        if (person instanceof Director)
            movieDirectors.add((Director) person);

        return "\"" + person.getName() + "\" adicionado ao filme \""+ this.getMovieName() +"\" com sucesso.";
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