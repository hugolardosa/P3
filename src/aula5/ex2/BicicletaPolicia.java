package aula5.ex2;

public class BicicletaPolicia extends Bicicleta implements Policia {

	public BicicletaPolicia(int numR, String cor, int ano, String marca) {
		super(numR, cor, ano, marca);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Emergencia getTipo() {
		return Emergencia.PSP;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "B_P_" + super.getId();
	}
	
	@Override
	public String toString() {
		return "Bicicleta de Polica: " + super.toString();
	}
}
