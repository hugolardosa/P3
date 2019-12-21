package aula2;
import java.util.*;

public class Soup {
	private int size;
	private char[][] puzzle;
	private ArrayList<String> s;
	
	public Soup(int size) {
		this.size = size;
		puzzle = new char[size][size];
		s = new ArrayList<String>();
	}
	
	public Soup() {
		this.size = 80;
		puzzle = new char[80][80];
		s = new ArrayList<String>();
	}
	public void loadArray(char[] c) {
		int y = 0;
		int x = 0;
		for (int i = 0; i < c.length; i++) {
			if ((i-(size-1))%size == 0) {
				puzzle[y][x] = c[i];
				y = 0;
				x++;
			} else {
				puzzle[y][x] = c[i];
				y++;
			}
		}
	}
	
	public void Solver(String palavra) {
		for (int y = 0; y < this.size; y++) {
			for (int x = 0; x < this.size; x++) {
				if(palavra.charAt(0) == puzzle[x][y]) {
						if(this.SolveLeft(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"left");
						}
						else if(this.SolveRight(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"right");
						}
						else if(this.SolveUp(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"up");
						}
						else if(this.SolveDown(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"Down");
						}
						else if(this.SolveLeftUp(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"UpLeft");
						}
						else if(this.SolveLeftDown(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"DownLeft");
						}
						else if(this.SolveRightUp(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"UpRight");
						}
						else if(this.SolveRightDown(x,y,palavra)) {
							System.out.printf("\n%s		%d,%d		%s",palavra,y+1,x+1,"DownRight");
						}
				}
			}
		}
	}
	
	public boolean SolveLeft(int x, int y, String palavra) {
		 if ((x + 1) - palavra.length() < 0) { //verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			 return false;
		 } //caso a palavra caiba
		 int indice = x; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[indice][y] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indice--; //anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public boolean SolveRight(int x, int y, String palavra) {
		if(x + palavra.length() > this.size) {//verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			return false;
		 } //caso a palavra caiba
		 int indice = x; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[indice][y] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indice++; //anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	public boolean SolveUp(int x, int y, String palavra) {
		 if ((y + 1) - palavra.length() < 0) { //verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			 return false;
		 } //caso a palavra caiba
		 int indice = y; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[x][indice] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indice--; //anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public boolean SolveDown(int x, int y, String palavra) {
		if(y + palavra.length() > this.size) {//verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			return false;
		 } //caso a palavra caiba
		 int indice = y; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[x][indice] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indice++; //anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public boolean SolveLeftUp(int x, int y, String palavra) {
		if((x + 1) - palavra.length() < 0 || (y + 1) - palavra.length() < 0) {//verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			return false;
		 } //caso a palavra caiba
		 int indicex = x;
		 int indicey = y; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[indicex][indicey] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indicex--;
	            indicey--;//anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public boolean SolveLeftDown(int x, int y, String palavra) {
		if((x + 1) - palavra.length() < 0 || y + palavra.length() > this.size) {//verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			return false;
		 } //caso a palavra caiba
		 int indicex = x;
		 int indicey = y; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[indicex][indicey] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indicex--;
	            indicey++;//anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public boolean SolveRightUp(int x, int y, String palavra) {
		if(x + palavra.length() > this.size || (y + 1) - palavra.length() < 0) {//verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			return false;
		 } //caso a palavra caiba
		 int indicex = x;
		 int indicey = y; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[indicex][indicey] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indicex++;
	            indicey--;//anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public boolean SolveRightDown(int x, int y, String palavra) {
		if(x + palavra.length() > this.size || y + palavra.length() > this.size) {//verificar primeiro se a palavra cabe na procura, para não dar (e fazemos x+1 porque os indices começam em 0)
			return false;
		 } //caso a palavra caiba
		 int indicex = x;
		 int indicey = y; //gravamos a posição do primeiro caracter numa variavel temporaria
		 for (char letter : palavra.toCharArray()) //para cada caracter da palavra vamos verificar 
	        {
	            if (puzzle[indicex][indicey] != letter) //se não for encontrada a letra seguinte devolve false
	                return false;
	            indicex++;
	            indicey++;//anda para a esquerda
	        }
		 return true; //caso encontre dê verdade
	}
	
	public void printpuzzle() {
		for (int x = 0; x < puzzle.length;x ++) {
			for (int i = 0; i < puzzle.length; i++) {
				System.out.print(puzzle[i][x]);
			}
			System.out.println();
		}
	}
	
	
	public ArrayList<String> getSolution(){
		return s;
	}
}
