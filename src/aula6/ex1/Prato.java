package aula6.ex1;
import java.util.*;

public class Prato {
	private String nome;
	LinkedList<Alimento> li;
	private double CalTotal;
	public Prato(String nome) {
		this.nome=nome;
		this.CalTotal  = 0;
		li = new LinkedList<>();
		
	}
	
	public double getCalTotal() {
		return CalTotal;
	}
	
	public void addCal(Double c) {
		this.CalTotal += c;
	}
	
	public String getNome() {
		return this.nome;
	}

	public boolean addIngrediente(Alimento a) {
		this.CalTotal += a.getCalorias();
		return li.add(a);	
	}

	public boolean removeIngrediente(Alimento a) {
		this.CalTotal -= a.getCalorias();
		return li.remove(a);
	}
	
	@Override
	public String toString() {
		String s = String.format("	-> Prato --> Nome: %s; Ingredientes: \n",this.nome);
		for(Alimento a: li) {
			s += "		--> " + a + " \n";
		}
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		else if (CalTotal != other.CalTotal)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(CalTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	public int compareTo(Prato prato2) {
		return (int)(CalTotal - prato2.CalTotal);
	}
	
}
