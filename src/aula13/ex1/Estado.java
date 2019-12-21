package aula13.ex1;

import java.util.Objects;

public class Estado extends Regiao {
    private Localidade capital;

    public Estado(String nome, int populacao, Localidade capital) throws IllegalArgumentException {
        super(nome, populacao);
        if(capital.getType() == TipoLocalidade.Cidade)this.capital=capital;
        else throw new IllegalArgumentException("Capital Invalida");
    }

    public Localidade getCapital() {
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
