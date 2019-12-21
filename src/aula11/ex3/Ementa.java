package aula11.ex3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Ementa implements Serializable {
	private String nome;
	private String local;
	private HashMap<DiaSemana,LinkedList<Prato>> f;
	private static final long serialversionUID = -489654;

	public Ementa(String nome, String local) {
		this.nome=nome;
		this.local=local;
		f = new HashMap<DiaSemana,LinkedList<Prato>>();
	}

	public void addPrato(Prato p, DiaSemana d) {
		if(f.containsKey(d))
			f.get(d).add(p);
		else {
			LinkedList<Prato> temp = new LinkedList<Prato>();
			temp.add(p);
			f.put(d, temp);
		}
	}

	@Override
	public String toString() {
		String s = "";
		DiaSemana[] dd = f.keySet().toArray(new DiaSemana[0]);
		Arrays.sort(dd);
		for (DiaSemana dp : dd) {
			s += dp + ": \n";
			for (int i = 0; i < f.get(dp).size(); i++) {
				s += f.get(dp).get(i).toString()  + " \n"; 
			}
		}
		return s;
	}
}
