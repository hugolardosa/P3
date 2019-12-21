package aula4.ex1;

import aula4.*;

public class Professor extends Pessoa {
	private int nfun;
	private static int nf = 100;
	private Data dataAdmissao;
	
	public Professor(String n, int c, Data d) {
		super(n, c, d);
		this.nfun = nf++;
		this.dataAdmissao = Data.today();		
	}
	
	
	public Professor(String n, int c, Data d, int nfun, Data Adm) {
		super(n, c, d);
		this.nfun = nfun;
		this.dataAdmissao = Adm;		
	}
	
	public int getNfun(){
		return this.nfun;
	}
	
	public Data getDadm() {
		return this.dataAdmissao;
	}
	
	@Override
	public String toString() {
		 return super.toString() + String.format("Nfunc: %d \n Admitido em Data: %s", this.nfun, this.dataAdmissao);
	 }
	
}
