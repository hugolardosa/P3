package aula1;

public class Quadrado {
	private double lado;
	public Quadrado(double l) {
		this.lado = l;
		
	}
	public double getLado() {
		return this.lado;
	}
	
	public double area() {
		return this.lado*this.lado;
	}
	public double perimetro() {
		return (this.lado*4);
	}
	public String toString() {
		return String.format("Lado: %f | Area: %f | Perimetro: %f", this.lado,this.area(),this.perimetro());
	}
}
