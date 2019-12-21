package aula3.ex2;

public class Rectangulo extends Figura{
	public Rectangulo(double co, double lg) {
		super(co,lg);
		
	}
	public Rectangulo(double co, double lg, Ponto c) {
		super(co,lg,c);
		
	}
	
	public Rectangulo(double x, double y, double co, double la) {
		super(co,la,new Ponto(x,y));
		
	}
	
	public Rectangulo(Rectangulo r) {
		super(r.getX(),r.getY(),r.getCentro());
		
	}
}
