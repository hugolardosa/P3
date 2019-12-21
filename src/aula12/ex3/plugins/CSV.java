package aula12.ex3.plugins;

import aula12.ex3.Data;
import aula12.ex3.IPlugin;
import aula12.ex3.Pessoa;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV implements IPlugin {

	@Override
	public boolean verifyclass(String name) {
		return "CSV".equalsIgnoreCase(name);
	}

	@Override
	public Pessoa[] InfoFromFile(String filen) throws IOException {
		Scanner s = new Scanner (new File(filen));
		s.nextLine();
		ArrayList<Pessoa> l = new ArrayList<>();
		while(s.hasNextLine()) {
			String[] values = s.nextLine().split("\t");
			System.out.println(values.length);
			for(String v: values)
				System.out.println(v);
			String nome = values[0];
			int contacto = Integer.parseInt(values[1]);
			String[] d = values[2].split("/");
			l.add(new Pessoa(nome,contacto,new Data(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]))));
		}
		s.close();
		return l.toArray(new Pessoa[0]);
	}

	@Override
	public void InfoToFile(String filen, Pessoa[] p) throws IOException {
		PrintWriter pf = new PrintWriter(new File(filen));
		pf.println("CSV");
		for (Pessoa pessoa : p) {
			pf.println(pessoa.getNome() + "\t" + pessoa.getContacto() + "\t" + pessoa.getData());
		}
	pf.close();
	}

}
