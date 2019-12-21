package aula5.ex3;

public class Pessoa {
	private String nome;
	private int contacto;
	private Data data;
	
	public Pessoa(String n, int c, Data d) {
		this.nome = n;
		this.contacto = c;
		this.data = d;		
	}

	@Override
	public String toString() {
		 return String.format("%s, Cel: %d, Data: %s", this.nome,this.contacto,this.data);
	 }
	public String getNome() {
		return this.nome;
	}
	public int getContacto() {
		return this.contacto;
	}
	public Data getData() {
		return this.data;
	}
}

