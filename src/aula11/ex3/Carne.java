package aula11.ex3;

import java.io.Serializable;

public class Carne extends Alimento implements Serializable {
	private VariedadeCarne c;

	public Carne(VariedadeCarne c, double protein, double calorias, double peso) {
		super(protein, calorias, peso);
		this.c = c;
		// TODO Auto-generated constructor stub
	}
	
	public VariedadeCarne getCarneType() {
		return this.c;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carne other = (Carne) obj;
		if (this.c != other.c)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Carne --> Variedade %s", c);
	}
}
