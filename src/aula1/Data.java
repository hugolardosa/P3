package aula1;

import java.util.Calendar;
//clase data do guião 1 com algumas alterações
public class Data {
	
	
	private int dia;
	private int mes;
	private int ano;
	
	
	/** Inicia esta data com o dia de hoje. */
	  public Data() {
	    Calendar today = Calendar.getInstance();
	    this.dia = today.get(Calendar.DAY_OF_MONTH);
	    this.mes = today.get(Calendar.MONTH) + 1;
	    this.ano = today.get(Calendar.YEAR);
	  }
	
	public Data(int d, int m, int a){
		if(dataValida(d,m,a)) {
			this.dia = d;
			this.mes = m;
			this.ano = a;
		}
		else {
			throw new IllegalArgumentException("Data Invalida");
		}
		
	}
	
	public int getDay() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getYear() {
		return this.ano;
	}
	
	// Indica se um terno (dia, mes, ano) forma uma data válida.
	 private boolean dataValida(int dia, int mes, int ano) {
		boolean valido = true;
		if (mes<1 || mes>12){valido=false;}
		if (ano<0){valido= false;}
		if (0>= dia || dia>diasDoMes(mes,ano)){valido= false;}
		return valido;
	  }
	 
	 private int diasDoMes(int m, int a){
		boolean isbiss = (a%4 == 0 && a%100 != 0 || a%400 == 0); //verifica se o ano é bissexto
		int[] dMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (m==2) {
			if(isbiss == true) {
				return dMes[m-1] + 1;
			}
			else {
				return dMes[m-1];
			}
		}
		else {
			return dMes[m-1];
		}
		
	 }
	 
	 @Override
	 public String toString() {
		    return String.format("%04d-%02d-%02d", ano, mes, dia);
	 }
	 
}
