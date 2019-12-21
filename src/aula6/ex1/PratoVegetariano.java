package aula6.ex1;

public class PratoVegetariano extends Prato implements AlimentoVegetariano {

	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	@Override
	public String toString() {
		return super.toString() + " PRATO VEGETARIANO";
	}

}
