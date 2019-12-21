package aula5.ex2;

public class Motorizado extends Veiculo {
	private int cilindrada;
	private int vlM;
	private String matricula;
	
	public Motorizado(int numR, String cor, int ano,int vlM, int cilindrada, String matricula) {
		super(numR, cor, ano);
		this.vlM = vlM;
		this.matricula = matricula;
		this.cilindrada = cilindrada;
	}
	
	public int getCilindrada() {
		return cilindrada;
	}

	public int getVelMax() {
		return vlM;
	}

	public String getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(". Motorizado: Cilindrada %d, VelociadeMaxima: %d, Matricula: %s", this.cilindrada,this.vlM,this.matricula);
	}
}
