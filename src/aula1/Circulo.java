package aula1;

public class Circulo {
	private double raio;
	private Ponto centro;
	
	public Circulo(Ponto center, double r) {
		this.raio = r;
		this.centro = center;
		
	}
	
	public Circulo(double x, double y, double r) {
		Ponto p 	= new Ponto(x,y);
		this.centro = p;	
		this.raio = r;
	}
	
	public double getRaio() {
		return this.raio;
	}
	
	public Ponto getCentro(){
		return this.centro;
	}
	
	public boolean isEqual(Circulo c2) {
		if(this.raio == c2.raio) {
			return true;
		}
		return false;
	}
	
	public double area() {
		return 3.14 * this.raio*this.raio;
	}
	public double perimetro() {
		return (2*3.14*this.raio);
	}
	
	public boolean intersect(Circulo c2) {
		double distancia = Math.sqrt(Math.pow((this.centro.getX() - c2.centro.getX()),2)+Math.pow((this.centro.getY() - c2.centro.getY()),2));
		if(this.raio + c2.raio > distancia) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return String.format("Raio: %f | Centro: %s | Area: %f |Perimetro: %f", this.raio,this.centro.toString(),this.area(),this.perimetro());
	}
}