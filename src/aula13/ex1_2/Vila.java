package aula13.ex1_2;

public class Vila extends Regiao implements TipoLocalidade {
    public Vila(String nome, int populacao) {
        super(nome, populacao);
    }

    @Override
    public String toString() {
        return " Vila" + super.toString();

    }
}

