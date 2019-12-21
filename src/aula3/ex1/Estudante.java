package aula3.ex1;

import aula3.Data;
import aula3.Pessoa;

public class Estudante extends Pessoa{
	private static int c_Nmecc = 100;
	private int Nmecc;
	private Data Datadeins;
	
	public Estudante(String iNome, int iBI, Data iDataNasc, Data iDataInsc){
		super(iNome, iBI, iDataNasc);
		Nmecc = c_Nmecc++;
		this.Datadeins = iDataInsc;
	}
	
	public Estudante(String iNome, int iBI, Data iDataNasc) {
		super(iNome, iBI, iDataNasc);
		Nmecc = c_Nmecc++;
		this.Datadeins = new Data();
	}
	
	public int nMec() {
		return Nmecc;
	}
	
	public Data dataIns() {
		return this.Datadeins;
	}
	
	@Override
	public String toString() {
		 return super.toString() + String.format(" NMEC: %d, Data: %s", Nmecc, this.Datadeins);
	 }
	
} 
