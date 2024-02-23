package catalogView;

import catalog.*;
import catalogController.ActorController;
import catalogController.DirectorController;
import catalogController.MovieController;
import utils.Menu;
import utils.Validator;

import java.util.Scanner;

public class Interactivity {
    static Scanner scanner = new Scanner(System.in);
    static DirectorController directorController = new DirectorController();
    static ActorController actorController = new ActorController();
    static MovieController movieController = new MovieController();

    public static void main(String[] args) {
        mainOptions();
    }

    public static void mainOptions() {
        int menuOption;

        do {
            Menu.showMenu();
            System.out.print("Selecione uma opção: ");
            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1:
                    System.out.println(showMovieFound());
                    break;
                case 2:
                    System.out.println(listAllMovies());
                    break;
                case 3:
                    subOptions();
                    break;
                case 4:
                    System.out.println("\nAté mais!");
                    break;
                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (menuOption != 3 && menuOption != 4) {
                System.out.print("\nPressione enter para continuar");
                scanner.nextLine();
            }

        } while (menuOption != 4);
    }

    public static String showMovieFound() {
        System.out.print("\nDigite o nome do filme: ");
        String movieName = scanner.nextLine();

        Movie movie = movieController.findMovieByName(movieName);

        if (movie != null) {
            return String.format("Filme encontrado: %s, lançamento: %s, orçamento: %d, descrição: %s, gênero: %s",
                    movie.getName(), movie.getReleaseDate(), movie.getBudget(), movie.getDescription(), movie.getGenre());
        } else {
            return "Filme não encontrado";
        }
    }

    public static String listAllMovies() {
        StringBuilder moviesList = new StringBuilder();

        for (Movie movie : movieController.listAllMovies()) {
            moviesList.append(String.format("\n%s, lançamento: %s, orçamento: %d, descrição: %s, gênero: %s",
                    movie.getName(), movie.getReleaseDate(), movie.getBudget(), movie.getDescription(), movie.getGenre()));
        }

        return moviesList.toString();
    }

    public static void subOptions() {
        int subOption;

        do {
            Menu.showSubMenu();
            System.out.print("Selecione uma opção: ");
            subOption = scanner.nextInt();
            scanner.nextLine();

            switch (subOption) {
                case 1:
                    System.out.println(addMovie());
                    break;
                case 2:
                    System.out.println(addDirector());
                    break;
                case 3:
                    System.out.println(addActor());
                    break;
                case 4:
                    System.out.println("\nRetornando ao menu principal");
                    break;
                default:
                    System.out.print("\nOpção inválida selecionada!");
            }

            if (subOption != 4) {
                System.out.print("\nPressione enter para continuar");
                scanner.nextLine();
            }

        } while (subOption != 4);
    }

    public static String addMovie() {
        System.out.print("\nDigite o nome do filme: ");
        String movieName = scanner.nextLine();

        System.out.print("Digite a data de lançamento do filme: ");
        String releaseDate = scanner.nextLine();
