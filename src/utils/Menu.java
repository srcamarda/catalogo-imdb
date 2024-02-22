package utils;

public class Menu {
    public static void showMenu() {
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

    public static void showOptions() {
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

    public static void showGenreOptions() {
        String menuGenre = """
                                
                >>>> Lista de gêneros disponíveis <<<<
                1 - Ação;
                2 - Comédia;
                3 - Drama;
                4 - Terror
                5 - Romance
                6 - Ficção
                7 - Fantasia
                8 - Aventura
                9 - Musical
                10 - Documentário
                """;

        System.out.println(menuGenre);
    }

    public static void showDirectorAreaOptions() {
        String menuDirectorArea = """
                                
                >>>> Lista de áreas disponíveis <<<<
                1 - Arte
                2 - Fotografia
                3 - Filmagem
                4 - Produção
                """;

        System.out.println(menuDirectorArea);
    }

    public static void showAssociationOptions() {
        String menuAssociationType = """
                                
                >>>> Lista de associações disponíveis <<<<
                1 - Associar um ator a um Filme
                2 - Associar um diretor a um filme
                """;

        System.out.println(menuAssociationType);
    }
}