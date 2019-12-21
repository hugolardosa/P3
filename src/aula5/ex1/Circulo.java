package aula5.ex1;

public class Circulo extends Figura{
	
	public Circulo(Ponto center, double r) {
		super(r,center);
		
	}
	
	public Circulo(double r) {
		super(r,new Ponto(0,0));
		
	}
	
	public Circulo(double x, double y, double r) {
		super(r,new Ponto(x,y));		
	}
	
	public Circulo(Circulo a) {
		super(a.getLado(),a.getCentro());
	}
	
	
	@Override
	public double area() {
		return Math.PI * super.lado*super.lado;
	}
	
	@Override
	public double perimetro() {
		return (2*Math.PI*super.lado);
	}
	
	public boolean intersect(Circulo c2) {
		double distancia = Math.sqrt(Math.pow((this.Centro.getX() - c2.Centro.getX()),2)+Math.pow((this.Centro.getY() - c2.Centro.getY()),2));
		if(super.lado + c2.lado > distancia) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("Raio: %2.2f | Centro: %s | Area: %2.2f |Perimetro: %2.2f", this.lado,this.Centro,this.area(),this.perimetro());
	}
}