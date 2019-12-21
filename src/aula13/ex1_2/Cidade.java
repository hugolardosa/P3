package aula13.ex1_2;

public class Cidade extends Regiao implements TipoLocalidade {

    public Cidade(String nome, int populacao) {
        super(nome, populacao);
    }

    @Override
    public String toString() {
        return " Cidade" + super.toString();
    }
}
