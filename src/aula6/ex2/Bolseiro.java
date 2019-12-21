package aula6.ex2;

public class Bolseiro extends Estudante{
	public int bolsa;
	public Bolseiro(String iNome, int iBI, Data iDataNasc, Data iDataInsc) {
		super(iNome, iBI, iDataNasc, iDataInsc);
	}
	
	public Bolseiro(String iNome, int iBI, Data iDataNasc ) {
		super(iNome, iBI, iDataNasc, Data.today());
	}
	
	public int bolsa() {
		return this.bolsa;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" Bolsa:%d", this.bolsa);
	}

	public void setBolsa(int i) {
		this.bolsa=i;
	}
}
