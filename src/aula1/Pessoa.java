package aula1;

public class Pessoa {
	private String nome;
	private int cc;
	private Data data;
	
	public Pessoa(String n, int c, Data d) {
		this.nome = n;
		this.cc = c;
		this.data = d;		
	}
	
	public String toString() {
		 return String.format("Nome: %s/CC: %d/Data de Nasc.: %s", this.nome,this.cc,this.data.toString());
	 }
	public String getName() {
		return this.nome;
	}
	public int getCC() {
		return this.cc;
	}
	/*
	public int compareToCC(Pessoa p2) {
		return this.cc - p2.cc;
	}
	public int compareToName(Pessoa p2) {
		return this.nome.compareToIgnoreCase(p2.nome);
	}
	*/
}
