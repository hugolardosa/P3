package aula6.ex1;

public class Peixe extends Alimento {
	private TipoPeixe f;
	
	public Peixe(TipoPeixe f, double protein, double calorias, double peso) {
		super(protein, calorias, peso);
		// TODO Auto-generated constructor stub
		this.f=f;
	}
	
	public TipoPeixe getFish() {
		return this.f;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((f == null) ? 0 : f.hashCode());
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
		Peixe other = (Peixe) obj;
		if (f != other.f)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Peixe --> Variedade %s", f);
	}
	
}
