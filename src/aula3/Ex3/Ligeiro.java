package aula3.Ex3;

public class Ligeiro extends Veiculo {
	private char v_type;
	
	public Ligeiro(int c, int p, int l, double pesobruto) {
		super(c,p,l,pesobruto);
		v_type='B';
	}
	
	public boolean CanDrive(Condutor i) {
		if (i.getLicence() == v_type) {
			return true;
		}
		return false;
	}
}
