package catalog;

public enum Genre {
    ACAO("Ação"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    TERROR("Terror"),
    ROMANCE("Romance"),
    FICCAO("Ficção"),
    FANTASIA("Fantasia"),
    AVENTURA("Aventura"),
    MUSICAL("Musical"),
    DOCUMENTARIO("Documentário");

    private final String genreName;

    Genre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}