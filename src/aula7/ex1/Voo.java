package aula7.ex1;

public class Voo {
	private Hora Chegada;
	private String Voo;
	private String Companhia;
	private String Origem;
	private Hora Atraso;
	private String Obs;
	
	public Voo(Hora Chegada, String Voo, String Companhia, String Origem, Hora Atraso, String Obs) {
		this.Chegada = Chegada;
		this.Voo = Voo;
		this.Companhia = Companhia;
		this.Origem = Origem;
		this.Atraso = Atraso;
		this.Obs = Obs;
	}
	
	public Hora getChegada() {
		return Chegada;
	}
	
	public String getVoo() {
		return Voo;
	}
	
	public String getCompanhia() {
		return Companhia;
	}
	
	public String getOrigem() {
		return Origem;
	}
	
	public Hora getAtraso() {
		return Atraso;
	}
	
	public String getObs() {
		return Obs;
	}
	
	public int getDelayM() {
		return (this.Atraso.getHora()*60 + this.Atraso.getMinuto());
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%-10s\t%-18s\t%-20s\t%-5s\t%s",  Chegada.toString(),
				Voo,
				Companhia,
				Origem.toString(),
				Atraso.isHourZero() ? "" : Atraso.toString(),
				Atraso.isHourZero() ? "" : "Previsto: "+Chegada.hatraso(Atraso));

	}
}
