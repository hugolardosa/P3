package aula7.ex1;

public class Hora implements Comparable<Hora>{
	private int h;
	private int m;
	
	public Hora(int h, int m) {
		this.h = h;
		this.m = m;
	}
	
	public int getHora() {
		return h;
	}
	
	public int getMinuto() {
		return m;
	}
	
	@Override
	public int compareTo(Hora h) {
		if(this.h == h.h) return this.m - m;
		else return this.h - h.h;
	}
	
	public Hora hatraso(Hora h) {
		int hora=this.h+h.h;
		int minuto=0;
		if(h.m+this.m>60) {
			hora++;
			minuto=(h.m+this.m)%60;
		}
		else {
			minuto=this.m+h.m;
		}
		if(hora>=24)hora=hora-24;
		return new Hora(hora,minuto);
	}
	
	public boolean isHourZero() {
		if (h==0 && m==0)return true;
		return false;
	}
	@Override
	public String toString() {
		return String.format("%d:%d",this.h,this.m);
	}
}
