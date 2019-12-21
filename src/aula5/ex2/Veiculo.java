package aula5.ex2;

public abstract class Veiculo implements Comparable<Veiculo>{
	static int ID_F = 1;
	private int id;
	private int ano;
	private int numR;
	private String cor;
	
	public Veiculo(int numR, String cor, int ano) {
		this.numR = numR;
		this.cor = cor;
		this.ano=ano;
		this.id = ID_F++;
	}
	
	public int getNumRodas() {
		return numR;
	}
	
	public String getColor() {
		return cor;
	}
	
	public int getId() {
		return id;
	}
	
	public int getAno() {
		return ano;
	}
	
	public int compareTo(Veiculo h) {
		return this.ano - h.ano;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %d, Ano: %d, Num. Rodas: %d, Cor: %s ", this.id, this.ano, this.numR, this.cor);
	}
}
