package aula7.ex1;

public class VooAtraso implements Comparable<VooAtraso>{
	private String companhia;
	private int atraso;
	
	public VooAtraso(String companhia, int atraso) {
		this.companhia = companhia;
		this.atraso = atraso;
	}
	
	
	@Override
	public int compareTo(VooAtraso obj) {
		return this.atraso - obj.atraso;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VooAtraso other = (VooAtraso) obj;
		if (companhia == null) {
			if (other.companhia != null) {
				return false;
			}
		} else if (!companhia.equals(other.companhia)) {
			return false;
		}
		return true;
	}
	
	public String getCompanhia() {
		return companhia;
	}
	
	public int getAtraso() {
		return atraso;
	}
}
