package aula8.ex1;

import javax.swing.JToggleButton;

public class Engine {
	private String fsymb;
	private int count;
	private String[][] game;
	
	public Engine(String fsymb) {
		this.fsymb = fsymb;
		this.count = 0;
		game = new String[3][3];
	}
	
	public String getActuallSymb() {
		return fsymb;
	}
		
	public void play (JToggleButton d, int i, int j) {
		count++;
		if(fsymb.equals("X")) {
			if(d.getText() == "") {
				d.setText(fsymb);
				game[i][j] = "X";
			}
			
			boolean w = Win();
			if (w == true) {
				JogoDoGalo.PrintResult(fsymb, true);
			}
			
			else if(count == 9) {
				JogoDoGalo.PrintResult(fsymb, false);
			}
			
			fsymb = "O";
		}
		
		
		else if(fsymb.equals("O")) {
			if(d.getText() == "") {
				d.setText(fsymb);
				game[i][j] = "O";
			}
			boolean w = Win();
			
			if (w == true) {
				JogoDoGalo.PrintResult(fsymb, true);
			}
			
			else if(count == 9) {
				JogoDoGalo.PrintResult(fsymb, false);
			}
			fsymb = "X";
		}
				
		
	}
	
	
	private boolean Win() {
		boolean w = true;

		//check lines
		for (int i = 0; i < 3; i++) {
			w= true;
			for (int j = 0; j < 3; j++) {
				if((game[i][j] != (fsymb))) w = false;			
			}
			if(w) {
				return true;
			}
		}
		//check collums
		for (int i = 0; i < 3; i++) {
			w= true;
			for (int j = 0; j < 3; j++) {
				if((game[j][i] != (fsymb))) w = false;			
			}
			if(w) {
				return true;
			}
		}
		
		//check diagonal 
		if(game[0][0] == (fsymb) && game[1][1] == (fsymb) && game[2][2] == (fsymb))return true;
		if(game[0][2] == (fsymb) && game[1][1] == (fsymb) && game[2][0] == (fsymb))return true;
		return false;
	}
	
	//Function for debugging (Prints the game array on console)
	//Unused in main GUI Class
		public void PrintArray() {
			for (int i = 0; i < game.length; i++) {
				
				for (int j = 0; j < game.length; j++) {
				System.out.print("|");
				if(game[i][j] == null) System.out.print("-");
				else	System.out.print(game[i][j]);
				System.out.print("|");
				}
			System.out.println("");
			}
		}
	
}
