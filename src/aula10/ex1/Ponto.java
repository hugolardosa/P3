package aula10.ex1;

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
	
	public double distance(Ponto c2) {
		return Math.sqrt(Math.pow((this.x - c2.getX()),2)+Math.pow((this.y - c2.getY()),2));
	}
	@Override
	public String toString() {
		return String.format("X: %2.2f | Y: %2.2f", this.x,this.y);
	}
	
}
