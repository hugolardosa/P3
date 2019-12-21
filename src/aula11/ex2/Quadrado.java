package aula11.ex2;

public class Quadrado extends Rectangulo {
	public Quadrado(double l) {
		super(l,l);

	}
	public Quadrado(double l, Ponto c) {
		super(l,l,c);
		
	}
	
	public Quadrado(double x, double y, double l) {
		super(l,l,new Ponto(x,y));
	}
	
	public Quadrado(Quadrado a) {
		super(a.getLado(),a.getLado(),a.getCentro());
		
	}
	
	@Override
	public double area() {
		return super.lado*super.lado;
	}
	@Override
	public double perimetro() {
		return ((super.lado*4));
	}
	
	
	@Override
	public String toString() {
		return String.format("Centro: %s | Lado: %2.2f | Area: %2.2f | Perimetro: %2.2f",super.Centro,super.getLado(),this.area(),this.perimetro());
	}
}
