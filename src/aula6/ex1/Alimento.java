package aula6.ex1;


public abstract class  Alimento implements Comparable<Alimento>{
	private double protein;
	private double calorias;
	private double peso;
	
	public Alimento(double protein,double  calorias, double peso) {
		this.protein=protein;
		this.calorias=calorias;
		this.peso=peso;
	}
	
	public double getProtein() {
		return this.protein;
	}
	
	public double getCalorias() {
		return this.calorias;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	@Override
	public int compareTo(Alimento alimento) {
		return (int)(calorias-alimento.calorias);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(protein);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if(this.calorias != other.calorias) 
			return false;
		if(this.protein != other.protein)
			return false;
		if(this.peso != other.peso)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Alimento --> Proteinas: %3.2f, Calorias: %3.2f, Peso:%3.2f ", this.protein,this.calorias, this.peso);
	}
}
