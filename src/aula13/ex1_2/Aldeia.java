package aula13.ex1_2;

public class Aldeia extends Regiao implements TipoLocalidade {

    public Aldeia(String nome, int populacao) {
        super(nome, populacao);
    }

    @Override
    public String toString() {
        return " Aldeia" + super.toString();
    }
}
