package aula11.ex3;

import java.io.Serializable;

public class PratoVegetariano extends Prato implements AlimentoVegetariano, Serializable {

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return super.toString() + " PRATO VEGETARIANO";
    }

}
