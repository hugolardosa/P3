package aula13.ex1;

import java.util.Objects;

public class Localidade extends Regiao{
    private TipoLocalidade type;

    public Localidade(String nome, int populacao, TipoLocalidade type) {
        super(nome, populacao);
        this.type=type;
    }


    public void setType(TipoLocalidade type) {
        this.type = type;
    }


    public TipoLocalidade getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Localidade that = (Localidade) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return " " +type + super.toString();
    }

}

