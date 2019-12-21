package aula2;


public class Cliente {
	private int Nfunc;
	private int NIF;
	private int Numsocio;
	private Data Datadeins;
	private String Nome;
	private int NumCC;
	private Data Born;
	private int Nmecc;
	private String Curso;
	private char type;
	private boolean rent;
	private int N;
	
	public Cliente(int Nfunc, int NIF, int Numsocio, Data Datadeins, String Nome, int NumCC, Data Born) {
		this.Nmecc=0;
		this.Curso="None";
		this.Nfunc=Nfunc;
		this.NIF=NIF;
		this.Numsocio=Numsocio;
		this.Datadeins=Datadeins;
		this.Nome=Nome;
		this.NumCC=NumCC;
		this.Born=Born;
		this.type = 'f';
		this.rent = false;
		this.N = 1;
	}
	
	public Cliente(int Nmecc, String Curso, int Numsocio, Data Datadeins, String Nome, int NumCC, Data Born) {
		this.Nmecc=Nmecc;
		this.Curso=Curso;
		this.Nfunc=0;
		this.NIF=0;
		this.Numsocio=Numsocio;
		this.Datadeins=Datadeins;
		this.Nome=Nome;
		this.NumCC=NumCC;
		this.Born=Born;
		this.type = 'e';
		this.rent = false;
		this.N = 1;
	}
	
	public int getNumFunc() {
		return this.Nfunc;
	}
	
	public int getNIF() {
		return this.NIF;
	}
	
	public int getNumsocio() {
		return this.Numsocio;
	}
	
	public Data getDatadeins(){
		return this.Datadeins;
	}
	public String getNome() {
		return this.Nome;
	}
	public int getNumCC() {
		return this.NumCC;
	}
	public Data getBorn() {
		return this.Born;
	}
	
	public int getNmecc() {
		return this.Nmecc;
	}
	
	public String getCurso() {
		return this.Curso;
	}
	
	public char getType() {
		return this.type;
	}
	
	public boolean check() {
		return this.rent;
	}
	
	public void ChangeState(boolean rent) {
		this.rent=rent;
	}
	public int getN() {
		return this.N;
	}
	public void addN() {
		this.N++;
	}
	public void subN() {
		this.N--;
	}
	
	public int getAge() {
		Data hoje = new Data();
		int age = hoje.getYear()-this.Born.getYear();
		if(hoje.getMes() - this.Born.getMes() < 0) {
			return age-1;
		}
		if(hoje.getMes() - this.Born.getMes() == 0) {
			if(hoje.getDay()- this.Born.getDay()<0) {
				return age-1;
			}
		}
		return age;
	}
	
	@Override
	public String toString() {		
		if(this.type == 'e') {
			return String.format("%3d |   %s   |  %d  | %s | %s | %d | %s |", this.Nmecc, this.Curso, this.Numsocio, this.Datadeins, this.Nome, this.NumCC, this.Born);
		}
		return String.format("%3d |   %d   |  %d  | %s | %s | %d | %s |", this.Nfunc, this.NIF, this.Numsocio, this.Datadeins, this.Nome, this.NumCC, this.Born);
	}
}
