package aula1;

import java.util.*;


public class Ex1 {
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Input a String");
		String frase = kb.nextLine();
		System.out.println("Total of Digits on the String: ");
		System.out.println(TotalofDigits(frase));
		System.out.println("All Upper: ");
		System.out.println(AllUpper(frase));
		System.out.println("All Lower: ");
		System.out.println(AllLower(frase));
		System.out.println("Number of words: ");
		System.out.println(numberofwords(frase));
		System.out.println(Swap(frase));
	}
	
	
	public static int TotalofDigits(String s) {
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean AllUpper(String s) {
		boolean test = true;
		for (int i = 0; i < s.length(); i++) {
			//testar se há um char lower e passar a false
			if(Character.isLowerCase(s.charAt(i))) {
				test=false;
			}
		}
		return test;
	}
	
	
	public static boolean AllLower(String s) {
		boolean test = true;
		for (int i = 0; i < s.length(); i++) {
			//testar se há um char Upper Case se sim passar a false
			if(Character.isUpperCase(s.charAt(i))) {
				test=false;
			}
		}
		return test;
	}
	
	public static int numberofwords(String s) {
		String words[] = s.split(" ");
		return words.length;		
	}
	
	public static String Swap(String s){
			char temp[] = s.toCharArray();
			char troca;
			for (int j = 0; j < temp.length -1; j+=2) {
				troca = temp[j];
				temp[j] = temp[j+1];
				temp[j+1] = troca;
			}
			String f = new String(temp);
			return f;
		}
	/* Indicar se só tem minúsculas.
	 c) Indicar se só tem maiúsculas.
	 d) Total de palavras lidas, imprimindo-as no ecrã.
	 e) Imprimir uma nova String na qual todos os caracteres foram trocados 2 a 2 (ex:
	 "comando" à "ocamdno").
	*/
}
