package aula3.Ex3;

import aula3.Data;
import aula3.Pessoa;

public class Condutor extends Pessoa {
	private char licence;
	public Condutor(String n, int c, Data d, char l) {
		super(n,c,d);
		this.licence=l;
	}
	
	public char getLicence() {
		return licence;
	}
}
