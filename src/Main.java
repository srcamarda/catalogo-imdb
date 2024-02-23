package catalogView;

import catalog.*;
import catalogController.*;
import utils.*;
import java.util.Scanner;

public class Interactivity {
    static Scanner scanner = new Scanner(System.in);
    static DirectorController directorController = new DirectorController();
    static ActorController actorController = new ActorController();
    static MovieController movieController = new MovieController();

    public static Movie searchMovie() {
        System.out.println("Digite o nome do filme");
        String userInputMovieName = scanner.nextLine();
        return movieController.searchMovie(userInputMovieName);
    }
