package aula11.ex1_steam;

public abstract class Figura implements Comparable<Figura>{
	public double lado;
	public Ponto Centro;

	public Figura(double lado) {
		this.lado = lado;
		this.Centro = new Ponto(0,0);
	}

	public Figura(double lado , Ponto c) {
		this.lado = lado;
		this.Centro = c;
	}
	public abstract double area();
	public abstract double perimetro();
	
	public double getLado() {
		return this.lado;
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
		if(lado != other.lado)
			return false;
		return true;
	}
	
	public int compareTo(Figura hs) {
		if(hs == null)
			throw new NullPointerException("A figura a comparar é nula");
		if(this.area() - hs.area() < 0)
			return -1;
		else if(this.area() - hs.area() > 0)
			return 1;
		return 0;
	}
		
	public Ponto getCentro(){
		return this.Centro;
	}
	
	@Override
	public String toString() {
		return String.format("Lado: %2.2f | Centro:  %s  | Area: %2.2f | Perimetro: %2.2f", this.lado ,this.Centro,this.area(),this.perimetro());
	}	
}
