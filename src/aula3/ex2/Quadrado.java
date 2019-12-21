package aula3.ex2;

public class Quadrado extends Figura{
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
		super(a.getX(),a.getY(),a.getCentro());
		
	}
	
	
	@Override
	public String toString() {
		return String.format("Centro: %s | Lado: %f | Area: %f | Perimetro: %f",super.Centro,super.getX(),this.area(),this.perimetro());
	}
}
