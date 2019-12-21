package aula2;

public class Video {
	private int ID;
	private String Titulo;
	private String Categoria;
	private String Idade;
	private boolean lent;
	private double rm;
	private int rt;
	private int somas_m;
	
	public Video(int id, String titulo, String Categoria, String idade) {
		this.ID=id;
		this.Titulo=titulo;
		this.Categoria=Categoria;
		this.Idade=idade;
		this.lent = false;
		this.rm = 0;
		this.rt = 0;
	}
	
	public int getID() {
		return this.ID;
	}
	public String getTitulo(){
		return this.Titulo;
	}
	public String Categoria() {
		return this.Categoria;
	}
	public String Idade() {
		return this.Idade; 
	}
	public boolean check() {
		return this.lent;
	}
	public void ChangeState(boolean lent) {
		this.lent = lent;
	}
	
	public void giveRank(int r) {
		rt = rt + 1;
		somas_m = somas_m + r;
		rm = somas_m / rt;
	}
	
	public double getRM() {
		return this.rm;
	}
	
	public int getRT() {
		return this.rt;
	}
	
	public int getAgeLimit() {
		String f = this.Idade.substring(1,this.Idade.length());
		int limit;
		try {
			limit = Integer.parseInt(f);
		}
		catch(Exception e) {
			limit = 0;
		}
		return limit;
	}
	
	@Override
	public String toString() {		
		return String.format("%3d |   %s   |  %s  | %s | ranking medio: %1.2f | ranking total: %d", this.ID, this.Titulo, this.Categoria, this.Idade, this.rm, this.rt);
		
	}
	
}
