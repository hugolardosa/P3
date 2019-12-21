package aula2;

import java.io.*;
import java.util.*;
public class Ex2 {

	public static void main(String[] args) {
		File f;
		Scanner fs = null;
		Scanner fw = null;
		try {
			f = new File(args[0]);
			fs = new Scanner(f);
			fw = new Scanner(f);
		}
		catch(Exception e) {
			System.out.println("File I/O error. Try Again");
			System.exit(1);
		}
		//Conta tamanho do puzzle
		int size = 0;
		String puzzle_t = ""; //cria um Arraylist com o puzzle
		while(fs.hasNextLine()) {
            String line = fs.nextLine();
			if(Character.isUpperCase(line.charAt(0))) //para verificar se é linha do puzzle se a linha for igual a linha em UpperCase
				puzzle_t += line; //adiciona linha do puzzle ao ArrayList
		}
		char c[] = puzzle_t.toCharArray();
		fs.close();
		
		
        ArrayList<String> palavras = new ArrayList<String>();
        while(fw.hasNext()){ 
        	String w_t = fw.next();
        	if(w_t.charAt(w_t.length()-1) == ',') {
        		w_t = w_t.substring(0, w_t.length()-1);
        		palavras.add(w_t.toUpperCase());
        	}
        	else if(Character.isLowerCase(w_t.charAt(0))) {
        		w_t = w_t.substring(0, w_t.length());
        		palavras.add(w_t.toUpperCase());
        	}
        }
		fw.close();
        
        size = (int)Math.sqrt(c.length);
		Soup s = new Soup(size);
			
		s.loadArray(c);
		
		s.printpuzzle();
		System.out.println();
		
		for (int i = 0; i < palavras.size(); i++) {
			String p = palavras.get(i);
			s.Solver(p);
		}
	}

}
