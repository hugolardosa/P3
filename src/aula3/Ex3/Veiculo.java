package aula3.Ex3;

public class Veiculo {
	private int Cilindrada;
	private double Potencia;
	private int Lotacao;
	private double pesobruto;
	private int Ocupantes;
	public Veiculo(int c, int p, int l, double pesobruto) {
		this.Cilindrada=c;
		this.Potencia=p;
		this.Lotacao=l;
		this.pesobruto=pesobruto;
		this.Ocupantes = 0;
	}
	
	public int getCilindrada() {
		return this.Cilindrada;
	}
	
	public double getPotencia() {
		return this.Potencia;
	}
	
	public int getLotação() {
		return this.Lotacao;
	}
	public double getPesoBruto() {
		return this.pesobruto;
	}
	
	public int getOcupantes() {
		return this.Ocupantes;
	}
	
	public void addPassageiro() {
		if(Lotacao > Ocupantes) {
			this.Ocupantes++;
			System.out.printf("\n Passageiro adicionado tem %d passageiros", this.Ocupantes);
		}
		else
			System.out.printf("\n Excedeu o numero limite. Algum passageiro tem que sair");
	}
	
	public void removePassageiro() {
		if(Ocupantes > 0) {
			this.Ocupantes--;
			System.out.printf("\n Passageiro Removido tem %d passageiros", this.Ocupantes);
		}
		else
			System.out.printf("\n Não tem nenhum passageiro no veiculo");
	}
}
