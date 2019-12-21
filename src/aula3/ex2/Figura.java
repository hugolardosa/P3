package aula3.ex2;

public class Figura {
	public double ly;
	public double lx;
	public Ponto Centro;
	
	public Figura(double lx, double ly) {
		this.lx = lx;
		this.ly = ly;
		this.Centro = new Ponto(0,0);
	}
	
	public Figura(double lx, double ly,Ponto c) {
		this.lx = lx;
		this.ly = ly;
		this.Centro = c;
	}
	public double area() {
		return this.lx*this.ly;
	}
	public double perimetro() {
		return ((this.lx*2) + (this.ly*2));
	}
	public double getY() {
		return this.ly;
	}
	public double getX() {
		return this.lx;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		if(Centro == null) {
			if(other.Centro != null)
				return false;
		} else if(!(Centro.equals(other.Centro))) {
			return false;
		}
		if(lx != other.lx || ly != other.ly)
			return false;
		return true;
	}
		
	public Ponto getCentro(){
		return this.Centro;
	}
	
	@Override
	public String toString() {
		return String.format("Lado X: %2.2f | Lado Y: %2.2f | Centro:  %s  | Area: %2.2f | Perimetro: %2.2f", this.lx,this.ly,this.Centro,this.area(),this.perimetro());
	}	
}
