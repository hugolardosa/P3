package aula5.ex1;

import java.util.ArrayList;

public class ColecaoFiguras {
	private double maxArea;
	private double totalArea;
	private ArrayList<Figura> f;
	public ColecaoFiguras(double maxArea) {
		this.maxArea=maxArea;
		f = new ArrayList<Figura>();
	}
	public boolean addFigura(Figura f) {
		if (exists(f)) return false;
		else if (areaTotal() + f.area() <= maxArea ) {
			totalArea += f.area();
			return this.f.add(f);
		}
		else return false;
	}
	public boolean delFigura(Figura f) {
		if (exists(f)) {
			totalArea -= f.area(); 
			return this.f.remove(f);
		}
		return false;
	}
	public double areaTotal() {
		return totalArea;
	}
	
	public boolean exists(Figura f) {
		return this.f.contains(f);
	}
	
	@Override
	public String toString() {
		return String.format("Area máxima %f", this.maxArea);
	}
	
	public Figura[] getFiguras() {
		return this.f.toArray(new Figura[0]);
	}
	public Ponto[] getCentros() {
		Ponto[] temp = new Ponto[this.f.size()];
		for (int i = 0; i < f.size(); i++) {
			temp[i] = this.f.get(i).getCentro();
		}
		return temp;
	}

}
