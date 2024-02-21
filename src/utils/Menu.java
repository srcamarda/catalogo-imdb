package utils;

public class Menu {
    public static void showMenu(){
        String menuStr = """
                
                #########################
                ##### CATÁLOGO IMDB #####
                #########################
                                
                >>>> Menu <<<<
                1 - Pesquisar filme
                2 - Lista de filmes
                3 - Opções de cadastro
                4 - Sair
                """;

        System.out.println(menuStr);
    }

    public static void showOptions(){
        String menuStr = """
                      
                >>>> Cadastro <<<<
                1 - Cadastrar filme
                2 - Cadastrar ator
                3 - Cadastrar diretor
                4 - Adicionar associações
                5 - Voltar
                """;

        System.out.println(menuStr);
    }
}