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

    //Options for the main menu
    public static void mainOptions() {
        int menuOption;

        do {
            Menu.showMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1: //Search movie
                    System.out.println(Interactivity.showMovieFound());
                    break;

                case 2: //List all movies
                    System.out.println(Interactivity.listAllMovies());
                    break;

                case 3: //Register options
                    subOptions();
                    break;

                case 4: //Exit
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

    //Options for the register sub menu
    public static void subOptions() {
        int subMenuOption;

        do {
            Menu.showOptions();
            System.out.print("Selecione uma opção: ");

            subMenuOption = scanner.nextInt();
            scanner.nextLine();

            switch (subMenuOption) {
                case 1: //Add movie
                    System.out.println(Interactivity.addMovie());
                    break;

                case 2: //Add actor
                    System.out.println(Interactivity.addActor());
                    break;

                case 3: //Add director
                    System.out.println(Interactivity.addDirector());
                    break;

                case 4: //Add associations
                    System.out.println(Interactivity.associatePersonWithMovie());
                    break;
            }

            if (subMenuOption < 1 || subMenuOption > 5)
                System.out.print("\nOpção inválida selecionada!");

            if (subMenuOption != 5) {
                System.out.print("\nPressione enter para continuar");
                scanner.nextLine();
            }

        } while (subMenuOption != 5);
    }

    //Search movie by name
    public static Movie searchMovie() {
        System.out.print("Digite o nome do filme: ");
        String userInputMovieName = scanner.nextLine();

        return movieController.searchMovie(userInputMovieName);
    }

    //Show movie if found
    public static String showMovieFound() {
        Movie movieFound = searchMovie();

        if (movieFound == null)
            return "Filme não encontrado no cadastro";

        return "Filme encontrado!\n" + movieFound;
    }

    //List all registered movies
    public static String listAllMovies() {
        return movieController.getRegisteredMovies();
    }

    //Add a movie
    public static String addMovie() {

        System.out.print("\nDigite o nome do filme: ");
        String movieName = scanner.nextLine();

        System.out.print("Digite a data de lançamento do filme: ");
        String releaseDate = scanner.nextLine();

        System.out.print("Digite o orçamento do filme: ");
        int movieBudget = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a descrição do filme: ");
        String movieDescription = scanner.nextLine();

        int genreOption;

        while (true) {
            Menu.showGenreOptions();
            System.out.print("Digite o número do gênero: ");
            genreOption = scanner.nextInt();
            scanner.nextLine();

            if (genreOption >= 1 && genreOption <= 10) {
                break;
            } else {
                System.out.print("Por favor, digite um número de gênero válido. Pressione enter para continuar");
                scanner.nextLine();
            }
        }

        Genre genre = switch (genreOption) {
            case 1 -> Genre.ACAO;
            case 2 -> Genre.COMEDIA;
            case 3 -> Genre.DRAMA;
            case 4 -> Genre.TERROR;
            case 5 -> Genre.ROMANCE;
            case 6 -> Genre.FICCAO;
            case 7 -> Genre.FANTASIA;
            case 8 -> Genre.AVENTURA;
            case 9 -> Genre.MUSICAL;
            case 10 -> Genre.DOCUMENTARIO;
            default -> null;
        };

        return movieController.registerMovie(movieName, releaseDate, movieBudget, movieDescription, genre);
    }

    //Add a actor
    public static String addActor() {
        String[] actorInfo = personData("ator");

        System.out.print("Digite o nome artístico do ator: ");
        String actorStageName = scanner.nextLine();

        if (Validator.nullOrEmpty((actorStageName))) {
            System.out.println("Por favor, não deixe o nome artístico do ator em branco.");
            return null;
        }

        if (actorInfo != null)
            return actorController.registerActor(actorInfo[0], actorInfo[1], actorStageName);
        else
            return "Não foi possível cadastrar o ator.";
    }

    //Add a director
    public static String addDirector() {
        String[] directorInfo = personData("diretor");

        int directorAreaOption;
        if (directorInfo != null) {
            while (true) {
                Menu.showDirectorAreaOptions();
                System.out.print("Digite o número da área do diretor: ");
                directorAreaOption = scanner.nextInt();
                scanner.nextLine();

                if (directorAreaOption >= 1 && directorAreaOption <= 4) {
                    break;
                } else {
                    System.out.print("Por favor, digite um número de área do diretor válido. Pressione enter para continuar");
                    scanner.nextLine();
                }
            }

            Area directorArea = switch (directorAreaOption) {
                case 1 -> Area.ARTE;
                case 2 -> Area.FOTOGRAFIA;
                case 3 -> Area.FILMAGEM;
                case 4 -> Area.PRODUCAO;
                default -> throw new IllegalArgumentException("Opção inválida: " + directorAreaOption);
            };

            return directorController.registerDirector(directorInfo[0], directorInfo[1], String.valueOf(directorArea));

        }
        return "Não foi possível cadastrar o diretor";
    }

    //Fill data for person
    static String[] personData(String movieRole) {
        String[] personDataArray = new String[2];

        System.out.print("\nDigite o nome do " + movieRole + ": ");
        String personName = scanner.nextLine();

        if (Validator.nullOrEmpty((personName))) {
            System.out.println("Por favor, não deixe o nome do " + movieRole + " em branco.");
            return null;
        }

        System.out.print("Digite os últimos 4 dígitos do CPF do " + movieRole + ": ");
        String personCpf = scanner.next();
        scanner.nextLine();

        if (Validator.nullOrEmpty(personCpf) || !Validator.fakeCpfValidator(personCpf)) {
            System.out.println("O CPF do " + movieRole + " deve conter apenas os 4 dígitos finais.");
            return null;
        }

        personDataArray[0] = personName;
        personDataArray[1] = personCpf;

        return personDataArray;
    }

    //Link person (actor or director) to a movie
    public static String associatePersonWithMovie() {
        int associationOption;
        while (true) {
            Menu.showAssociationOptions();
            System.out.print("Selecione uma opção: ");
            associationOption = scanner.nextInt();
            scanner.nextLine();

            if (associationOption == 1 || associationOption == 2) {
                break;
            } else {
                System.out.print("\nPor favor, digite um número do tipo de associação válido. Pressione enter para continuar");
                scanner.nextLine();
            }
        }

        String personType = (associationOption == 1) ? "ator" : "diretor";

        System.out.print("\nDigite o CPF do " + personType + ": ");
        String personCpf = scanner.next();
        scanner.nextLine();

        if (!Validator.fakeCpfValidator(personCpf))
            return "Por favor, digite um CPF válido.";

        Movie movieFound = searchMovie();
        if (movieFound == null)
            return "Não foi possível encontrar o filme, verifique o nome e tente novamente.";

        if (personType.equals("ator"))
            return associateActorWithMovie(personCpf, movieFound);

        if (personType.equals("diretor"))
            return associateDirectorWithMovie(personCpf, movieFound);

        return "Tipo de pessoa não encontrado";
    }

    //Link a actor to a movie
    static String associateActorWithMovie(String actorCpf, Movie movie) {
        Actor actorFound = actorController.searchActor(actorCpf);
        if (actorFound == null)
            return "Não foi possível encontrar o cadastro do ator";

        return movie.addPersonToMovie(actorFound);
    }

    //Link a director to a movie
    static String associateDirectorWithMovie(String directorCpf, Movie movie) {
        Director directorFound = directorController.searchDirector(directorCpf);

        if (directorFound == null)
            return "Não foi possível encontrar o cadastro do diretor";

        return movie.addPersonToMovie(directorFound);
    }
}