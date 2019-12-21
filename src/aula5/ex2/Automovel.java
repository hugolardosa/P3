package aula5.ex2;

public class Automovel extends Motorizado {
	private int lotacao;
	
	public Automovel(int numR, String cor, int ano, int vlM, int cilindrada, String matricula, int lotacao) {
		super(numR, cor, ano, vlM, cilindrada, matricula);
		this.lotacao=lotacao;
	}
	
	public int getLotacao() {
		return lotacao;
	}
	
}
