package catalogo;

public class Ator extends Pessoa {

    private String nomeArtistico;

    public Ator(String nome, String cpf, String nomeArtistico) {
        super(nome, cpf);
        this.nomeArtistico = nomeArtistico;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }

    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    @Override
    public String toString() {
        return "Ator{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nomeArtistico='" + nomeArtistico + '\'' +
                '}';
    }
}
