package aula4.ex3;

public class Estudante extends Cliente {
	private int Nmecc;
	private String Curso;
	
	public Estudante(int Nmecc, String Curso, int Numsocio, Data Datadeins, String Nome, int NumCC, Data Born) {
		super(Numsocio, Datadeins, Nome, NumCC, Born);
		this.Nmecc=Nmecc;
		this.Curso=Curso;
	}
	
	public int getNmecc() {
		return this.Nmecc;
	}
	
	public String getCurso() {
		return this.Curso;
	}
	
	@Override
	public String toString() {		
		return String.format("%3d |   %s   |", this.Nmecc, this.Curso) + super.toString();
	}
}
