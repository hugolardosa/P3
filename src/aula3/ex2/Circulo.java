package aula3.ex2;

public class Circulo extends Figura{
	
	public Circulo(Ponto center, double r) {
		super(r,0,center);
		
	}
	
	public Circulo(double r) {
		super(r,0,new Ponto(0,0));
		
	}
	
	public Circulo(double x, double y, double r) {
		super(r,0,new Ponto(x,y));		
	}
	
	public Circulo(Circulo a) {
		super(a.getX(),0,a.getCentro());
		
	}
	
	
	@Override
	public double area() {
		return 3.14 * this.lx*this.lx;
	}
	
	@Override
	public double perimetro() {
		return (2*3.14*this.lx);
	}
	
	public boolean intersect(Circulo c2) {
		double distancia = Math.sqrt(Math.pow((this.Centro.getX() - c2.Centro.getX()),2)+Math.pow((this.Centro.getY() - c2.Centro.getY()),2));
		if(this.lx + c2.lx > distancia) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return String.format("Raio: %f | Centro: %s | Area: %f |Perimetro: %f", this.lx,this.Centro,this.area(),this.perimetro());
	}
}