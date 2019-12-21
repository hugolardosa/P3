package aula12.ex3;

import java.io.*;
import java.util.*;


abstract class PluginManager {
	public static IPlugin load(String name) throws Exception {
		Class<?> c = Class. forName (name);
		return (IPlugin) c.newInstance();
	}
}

public class Agenda {
	
	private ArrayList<Pessoa> ag =new ArrayList<>();

	public void load(String fname) throws IOException{
		File proxyList = new File("src/aula12/ex3/plugins");
		ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
		for (String f: proxyList.list()) {
			try {
				plgs.add(PluginManager. load ("aula12.ex3.plugins."+f.substring(0,f.lastIndexOf('.'))));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


		Scanner s = new Scanner (new File(fname));
		String ff = s.nextLine();
		s.close();
		IPlugin to_use = null;
		for (IPlugin actual : plgs){
			if(actual.verifyclass(ff)){
				to_use = actual;
			}
		}
		loadCon(to_use.InfoFromFile(fname));
	}
	
	public void write(String fname, IPlugin f) throws IOException{
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
