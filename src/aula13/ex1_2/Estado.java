package aula13.ex1_2;

import java.util.Objects;

public class Estado extends Regiao {
    private Cidade capital;

    public Estado(String nome, int populacao, Cidade capital) throws IllegalArgumentException {
        super(nome, populacao);
        this.capital=capital;
    }

    public Cidade getCapital() {
        return capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Estado estado = (Estado) o;
        return Objects.equals(capital, estado.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capital);
    }

    @Override
    public String toString() {
        return super.toString() + capital;
    }
}
