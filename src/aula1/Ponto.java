package aula1;

public class Ponto {
	private double x;
	private double y;
	
	public Ponto(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public String toString() {
		return String.format("X: %f | Y:%f", this.x,this.y);
	}
	
}
