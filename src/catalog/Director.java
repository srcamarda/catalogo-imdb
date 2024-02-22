package catalog;

public class Director extends Person {
    final private String area;

    public Director(String nome, String cpf, Area area) {
        super(nome, cpf);
        this.area = area.getDirectorArea();
    }

    @Override
    public String toString() {
        return "\"Diretor de " + area + ": " + super.toString() + "\"";
    }
}