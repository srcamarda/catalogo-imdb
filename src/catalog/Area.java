package catalog;

public enum Area {
    ARTE("Arte"),
    FOTOGRAFIA("Fotografia"),
    FILMAGEM("Filmagem"),
    PRODUCAO("Produção");

    private String directorArea;

    Area(String directorArea) {
        this.directorArea = directorArea;
    }

    public String getDirectorArea() {
        return directorArea;
    }
}