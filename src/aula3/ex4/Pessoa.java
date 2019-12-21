package aula3.ex4;

public class Pessoa {
	private String nome;
	private int cc;
	private Data data;
	
	public Pessoa(String n, int c, Data d) {
		this.nome = n;
		this.cc = c;
		this.data = d;		
	}
	
	@Override
	public String toString() {
		 return String.format("%s, BI: %d, Data: %s", this.nome,this.cc,this.data);
	 }
	public String getNome() {
		return this.nome;
	}
	public int getCC() {
		return this.cc;
	}
	
	public Data getBorn() {
		return this.data;
	}
}


