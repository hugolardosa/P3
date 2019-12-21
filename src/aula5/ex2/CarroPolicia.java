package aula5.ex2;

public class CarroPolicia extends Automovel implements Policia {

	public CarroPolicia(int numR, String cor, int ano, int vlM, int cilindrada, String matricula, int lotacao) {
		super(numR, cor, ano, vlM, cilindrada, matricula, lotacao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Emergencia getTipo() {
		// TODO Auto-generated method stub
		return Emergencia.PJ;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "C_P_" + super.getId();
	}

	@Override
	public String toString() {
		return "Carro de Polica: " + super.toString();
	}
}
