package aula8.ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoDoGalo {
	public static void main(String[] args) {
		Engine eng = new Engine(args[0]);
		
		JFrame f = new JFrame("Jogo do Galo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		JPanel content = new JPanel();
		content.setBackground(Color.WHITE);
		content.setLayout(new GridLayout(3,3));
		JToggleButton b1 = new JToggleButton("");
		JToggleButton b2 = new JToggleButton("");
		JToggleButton b3 = new JToggleButton("");
		JToggleButton b4 = new JToggleButton("");
		JToggleButton b5 = new JToggleButton("");
		JToggleButton b6 = new JToggleButton("");
		JToggleButton b7 = new JToggleButton("");
		JToggleButton b8 = new JToggleButton("");
		JToggleButton b9 = new JToggleButton("");
		b1.setFont(new Font("Arial", Font.BOLD, 50));
		b2.setFont(new Font("Arial", Font.BOLD, 50));
		b3.setFont(new Font("Arial", Font.BOLD, 50));
		b4.setFont(new Font("Arial", Font.BOLD, 50));
		b5.setFont(new Font("Arial", Font.BOLD, 50));
		b6.setFont(new Font("Arial", Font.BOLD, 50));
		b7.setFont(new Font("Arial", Font.BOLD, 50));
		b8.setFont(new Font("Arial", Font.BOLD, 50));
		b9.setFont(new Font("Arial", Font.BOLD, 50));
		content.add(b1);
		content.add(b2);
		content.add(b3);
		content.add(b4);
		content.add(b5);
		content.add(b6);
		content.add(b7);
		content.add(b8);
		content.add(b9);
		
		b1.addActionListener(new ActionListener() {
								 @Override
								 public void actionPerformed(ActionEvent actionEvent) {
									 eng.play(b1,0,0);
									 b1.setEnabled(false);
								 }
							 });
				//e -> {eng.play(b1,0,0);b1.setEnabled(false);});
				b2.addActionListener(e -> {
					eng.play(b2, 0, 1);
					b2.setEnabled(false);
				});
		b3.addActionListener(e -> {eng.play(b3,0,2);b3.setEnabled(false);});
		b4.addActionListener(e -> {eng.play(b4,1,0);b4.setEnabled(false);});
		b5.addActionListener(e -> {eng.play(b5,1,1);b5.setEnabled(false);});
		b6.addActionListener(e -> {eng.play(b6,1,2);b6.setEnabled(false);});
		b7.addActionListener(e -> {eng.play(b7,2,0);b7.setEnabled(false);});
		b8.addActionListener(e -> {eng.play(b8,2,1);b8.setEnabled(false);});
		b9.addActionListener(e -> {eng.play(b9,2,2);b9.setEnabled(false);});
		
		//f.setContentPane(content);
		f.add(content);
		f.setVisible(true);
	}
	
	public static void PrintResult(String Player, boolean ganho) {
		if(ganho) {
			JOptionPane.showMessageDialog(null,
					"Ganhou o jogador " + Player +" !");
			System.exit(1);
		}
		else {
			JOptionPane.showMessageDialog(null,
					"Empate !");
			System.exit(1);
		}
	}
}
