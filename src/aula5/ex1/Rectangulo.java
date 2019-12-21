package aula5.ex1;

public class Rectangulo extends Figura{
	private double l2;
	public Rectangulo(double co, double lg) {
		super(co);
		this.l2 = lg;
		
	}
	public Rectangulo(double co, double lg, Ponto c) {
		super(co,c);
		this.l2 = lg;		
	}
	
	public Rectangulo(double x, double y, double co, double la) {
		super(co,new Ponto(x,y));
		this.l2 = la;
		
	}
	
	public double getL2() {
		return l2;
	}
	
	@Override
	public double area() {
		return super.lado*this.l2;
	}
	@Override
	public double perimetro() {
		return ((super.lado*2) + (this.l2*2));
	}
	
	public Rectangulo(Rectangulo r) {
		super(r.getLado(),r.getCentro());
		this.l2 = r.l2;
		
	}
	
	@Override
	public String toString() {
		return String.format("Centro: %s | Largura: %2.2f | Comprimento: %2.2f | Area: %2.2f | Perimetro: %2.2f",super.Centro,super.getLado(),this.l2,this.area(),this.perimetro());
	}
}
