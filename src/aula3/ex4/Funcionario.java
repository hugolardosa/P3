package aula3.ex4;


public class Funcionario extends Cliente{
	private int Nfunc;
	private int NIF;
	
	public Funcionario(int Nfunc, int NIF, int Numsocio, Data Datadeins, String Nome, int NumCC, Data Born) {
		super(Numsocio, Datadeins, Nome, NumCC, Born);
		this.Nfunc=Nfunc;
		this.NIF=NIF;
	}
	
	public int getNumFunc() {
		return Nfunc;
	}
	
	public int getNIF() {
		return NIF;
	}
	
	@Override
	public String toString() {		
		return String.format("%3d |  %d  |", this.Nfunc, this.NIF) + super.toString();
	}
}
