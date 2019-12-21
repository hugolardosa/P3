package aula3.Ex3;

public class PesadoPass extends Veiculo {
	private char v_type;
	
	public PesadoPass(int c, int p, int l, double pesobruto) {
		super(c,p,l,pesobruto);
		v_type='D';
	}
	
	public boolean CanDrive(Condutor i) {
		if (i.getLicence() == v_type || i.getLicence() == 'B') {
			return true;
		}
		return false;
	}
}
