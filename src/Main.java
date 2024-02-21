import catalog.*;
import utils.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int menuOption, subMenuOption;

        do {
            //Show the initial menu
            Menu.showMenu();
            System.out.print("Selecione uma opção: ");

            menuOption = input.nextInt();
            input.nextLine();

            if (menuOption < 1 || menuOption > 4) {
                System.out.print("\nOpção inválida selecionada! Enter para continuar...");
                input.nextLine();
                continue;
            }

            switch (menuOption) {
                case 1: //Search movie
                    //searchMovie();
                    break;

                case 2: //List all movies
                    //listMovies();
                    break;

                case 3: //Register options
                    do {
                        //Show the sub menu
                        Menu.showOptions();
                        System.out.print("Selecione uma opção: ");

                        subMenuOption = input.nextInt();
                        input.nextLine();

                        if (subMenuOption < 1 || subMenuOption > 5) {
                            System.out.print("\nOpção inválida selecionada! Enter para continuar...");
                            input.nextLine();
                            continue;
                        }

                        switch (subMenuOption) {
                            case 1: //Add movie
                                //addMovie();
                                break;
                            case 2: //Add actor
                                //addActor();
                                break;
                            case 3: //Add director
                                //addDirector();
                                break;
                            case 4: //Add associations
                                //addAssociation();
                                break;
                        }

                    } while (subMenuOption != 5);
                    break;

                case 4: //Exit
                    System.out.println("\nAté mais!");
            }

        } while (menuOption != 4);

        input.close();
    }
}