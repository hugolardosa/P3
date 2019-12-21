package aula11.ex3;

import java.io.Serializable;

public class PratoDieta extends Prato implements Serializable {
	private double limcalorias;
	
	public PratoDieta(String nome, double limcalorias) {
		super(nome);
		this.limcalorias=limcalorias;
	}
	
	@Override
	public boolean addIngrediente(Alimento a) {
		if(this.limcalorias >= super.getCalTotal() + a.getCalorias()) {
			super.addCal(a.getCalorias());
			return li.add(a);

		}
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(super.getCalTotal());
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PratoDieta other = (PratoDieta) obj;
		if (limcalorias != other.limcalorias)
			return false;
		return true;
	}
	
	@Override
	public boolean removeIngrediente(Alimento a) {
		this.limcalorias = this.limcalorias - a.getCalorias();
		return li.remove(a);
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" PRATO DIETA, Total de calorias %3.2f o limite de cal. é %3.2f", this.getCalTotal(), this.limcalorias);
	}
}
