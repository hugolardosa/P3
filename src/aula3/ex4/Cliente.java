package aula3.ex4;

public class Cliente extends Pessoa{
	private int Numsocio;
	private Data Datadeins;
	private char type;
	private boolean rent;
	private int N;
	
	public Cliente(int Numsocio, Data Datadeins, String Nome, int NumCC, Data Born) {
		super(Nome, NumCC, Born);
		this.Numsocio=Numsocio;
		this.Datadeins=Datadeins;
		this.rent = false;
		this.N = 1;
	}
	
	public int getNumsocio() {
		return this.Numsocio;
	}
	
	public Data getDatadeins(){
		return this.Datadeins;
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
		int age = hoje.getYear()-this.getBorn().getYear();
		if(hoje.getMes() - this.getBorn().getMes() < 0) {
			return age-1;
		}
		if(hoje.getMes() - this.getBorn().getMes() == 0) {
			if(hoje.getDay()- this.getBorn().getDay()<0) {
				return age-1;
			}
		}
		return age;
	}
	
	@Override
	public String toString() {		
		return String.format(" %d  | %s | %s | %d | %s |",  this.Numsocio, this.Datadeins, super.getNome(), super.getCC(), super.getBorn());
	}
}
