package aula5.ex3;
import java.util.*;
import java.io.*;

public class Agenda {
	
	private ArrayList<Pessoa> ag =new ArrayList<>();

	public void load(String fname) throws IOException{
		Scanner s = new Scanner (new File(fname));
		String ff = s.nextLine();
		s.close();
		FileType a = null;
		if(ff.equals("CSV"))
			a = new CSV();
		else if(ff.equals("vCard"))
			a= new vCard();
		else if(ff.equals("Nokia"))
			a= new Nokia();
		loadCon(a.InfoFromFile(fname));
	}
	
	public void write(String fname, FileType f) throws IOException{
		f.InfoToFile(fname, ag.toArray(new Pessoa[0]));
	}
	
	public void loadCon(Pessoa[] p) {
		for (Pessoa pessoa : p) {
			ag.add(pessoa);
		}
	}
	
	public void removeCon(Pessoa p) {
		if(!ag.contains(p))
			System.out.println("Pessoa não consta da lista");
		ag.remove(p);
	}
	
	public int getNumContacts() {
		return ag.size();
	}
	
	@Override
	public String toString() {
		return ag.toString();
	}
}
