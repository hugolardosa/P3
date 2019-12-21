package aula3.ex4;
import java.util.*;

public class ListClient {
	private ArrayList<Cliente> c;
	public ListClient() {
		this.c = new ArrayList<Cliente>();
	}
	
	public void addClient(Cliente c) {
		this.c.add(c);
	}
	
	public void removeCliente(int numdeSocio) {
		for (int i = 0; i < c.size(); i++) {
			if(c.get(i).getNumsocio() == numdeSocio) {
				this.c.remove(i);
			}
		}
	}
	
	public Cliente searchbySocio(int num) {
		for (int i = 0; i < this.c.size(); i++) {
			if(this.c.get(i).getNumsocio() == num) {
				return this.c.get(i);
			}
		}
		return null;
	}
	
	public void PrintListCL() {
		for (int i = 0; i < this.c.size(); i++) {
			System.out.println(c.get(i));
		}		
	}
	

}
