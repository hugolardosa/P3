package aula5.ex3;

import java.io.*;
import java.util.*;

public class vCard implements FileType {

	@Override
	public Pessoa[] InfoFromFile(String filen) throws IOException {
		Scanner s = new Scanner (new File(filen));
		s.nextLine();
		ArrayList<Pessoa> l = new ArrayList<>();
		while(s.hasNextLine()) {
			String[] values = s.nextLine().split("#");
			String nome = values[1];
			int contacto = Integer.parseInt(values[2]);
			String[] d = values[3].split("/");
			l.add(new Pessoa(nome,contacto,new Data(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]))));
		}
		s.close();
		return l.toArray(new Pessoa[0]);
	}

	@Override
	public void InfoToFile(String filen, Pessoa[] p) throws IOException {
		PrintWriter pf = new PrintWriter(new File(filen));
		pf.println("vCard");
		for (Pessoa pessoa : p) {
			pf.println("#" + pessoa.getNome() + "#" + pessoa.getContacto() + "#" + pessoa.getData());
		}
	pf.close();
	}

}
