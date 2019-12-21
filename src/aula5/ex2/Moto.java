package aula5.ex2;

public class Moto extends Motorizado {
	private boolean sidecar;
	
	public Moto(int numR, String cor, int ano, int vlM, int cilindrada, String matricula, boolean sidecar) {
		super(numR, cor, ano, vlM, cilindrada, matricula);
		this.sidecar = sidecar;
	}
	
	public boolean hasSidecar() {
		return sidecar;
	}
}
