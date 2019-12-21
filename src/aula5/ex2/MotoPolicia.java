package aula5.ex2;

public class MotoPolicia extends Moto implements Policia {

	public MotoPolicia(int numR, String cor, int ano, int vlM, int cilindrada, String matricula, boolean sidecar) {
		super(numR, cor, ano, vlM, cilindrada, matricula, sidecar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Emergencia getTipo() {
		// TODO Auto-generated method stub
		return Emergencia.PSP;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "M_P_" + super.getId();
	}
	
	@Override
	public String toString() {
		return "Moto de Polica: " + super.toString();
	}
}
