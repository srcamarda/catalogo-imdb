package catalog;

public class Actor extends Person {
    private String stageName;
    public Actor(String name, String cpf, String stageName) {
        super(name, cpf);
        this.stageName = stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}