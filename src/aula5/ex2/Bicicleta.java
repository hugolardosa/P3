package aula5.ex2;

public class Bicicleta extends Veiculo {
	private String marca;
	public Bicicleta(int numR, String cor, int ano, String marca) {
		super(numR, cor, ano);
		this.marca=marca;
	}
		
	public String getMarca() {
		return marca;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(". Bicicleta: Marca %s", this.marca);
	}
}
