package aula1;

public class Retangulo {
	private double largura;
	private double comprimento;
	public Retangulo(double co, double lg) {
		this.comprimento = co;
		this.largura = lg;
		
	}
	public double area() {
		return this.comprimento*this.largura;
	}
	public double perimetro() {
		return ((this.comprimento*2) + (this.largura*2));
	}
	public double getLargura() {
		return this.largura;
	}
	public double getComprimento() {
		return this.comprimento;
	}
	
	public String toString() {
		return String.format("Largura: %f | Comprimeto: %f | Area: %f | Perimetro: %f", this.largura,this.comprimento,this.area(),this.perimetro());
	}
}
