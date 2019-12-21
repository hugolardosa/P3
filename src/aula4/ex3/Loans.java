package aula4.ex3;

import java.util.*;

public class Loans {
	private Hashtable<Integer,ArrayList<Integer>> hist;
	private Hashtable<Integer,ArrayList<Integer>> histCl;
	public Loans() {
		hist = new Hashtable<>();
		histCl = new Hashtable<>();
	}
	//Funções para tratar do checkIn e CheckOut de Filme
	public void CheckOut(int ID, int numdesocio, ListVideo vd, ListClient cl, int Nmax) {
		try {
			if(cl.searchbySocio(numdesocio).getN()<=Nmax) {
				if(vd.searchVideobyID(ID).check()==false) {
					if(vd.searchVideobyID(ID).getAgeLimit()<=cl.searchbySocio(numdesocio).getAge()) {
						vd.searchVideobyID(ID).ChangeState(true);
						cl.searchbySocio(numdesocio).ChangeState(true);
						cl.searchbySocio(numdesocio).addN();
					}
					else {
						System.out.println("O cliente não tem idade suficiente");
					}
				}
				else {
					System.out.println("Erro. Filme já foi alugado");
				}
			}
			else {
				System.out.println("O Cliente atingiu o numero de filmes permitido");
			}
			
		}
		catch(Exception e) {
			System.out.println("Erro. Cliente Inavido. Tente outra vez");
		}
		
	}
	public void CheckIn(int ID, int numdesocio, ListVideo vd, ListClient cl, int r) {
		try {
			if(vd.searchVideobyID(ID).check()==true) {
			vd.searchVideobyID(ID).ChangeState(false);
			cl.searchbySocio(numdesocio).ChangeState(false);
			add(numdesocio, ID);
			addCl(numdesocio, ID);
			vd.searchVideobyID(ID).giveRank(r);
			cl.searchbySocio(numdesocio).subN();
			}
			else {
				System.out.println("Esse video não foi alugado");
			}
		}
		catch(Exception e) {
			System.out.println("Erro. Cliente Inavido. Tente outra vez");
		}
		
	}
	
	public void add(int ns, int id) {
		ArrayList<Integer> a = hist.get(id);
		if(a == null) {
			a =new ArrayList<Integer>();
		}
		a.add(ns);
		hist.put(id, a);
	}
	
	public void addCl(int ns, int id) {
		ArrayList<Integer> a = histCl.get(ns);
		if(a == null) {
			a =new ArrayList<Integer>();
		}
		a.add(id);
		histCl.put(ns, a);
	}
	
	public ArrayList<Integer> search(int id) {
		return hist.get(id);
	}
	
	public ArrayList<Integer> searchbyClient(int ns) {
		return histCl.get(ns);
	}
}
