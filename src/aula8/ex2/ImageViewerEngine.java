package aula8.ex2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class ImageViewerEngine {
	
	//panel da imagem acedido por todas as funções
	private JPanel image;
	private String path;
	private String temppath;
	
	public void app() {
		
		JFrame frame = new JFrame("BMPViewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLayout(new BorderLayout());
		
		//JPanel com botões
		JPanel botoes = new JPanel();
		botoes.setBackground(Color.BLUE);
		botoes.setLayout(new FlowLayout());
		
		//botões
		JButton b1 = new JButton("Open file");
		JButton b2 = new JButton("Resize");
		JButton b3 = new JButton("Flip vertically");
		JButton b4 = new JButton("Flip horizontally");
		JButton b5 = new JButton("Save");
		JButton b6 = new JButton("Save as");
		botoes.add(b1);
		botoes.add(b2);
		botoes.add(b3);
		botoes.add(b4);
		botoes.add(b5);
		botoes.add(b6);
		//colocação dos botões
		frame.add(botoes, BorderLayout.NORTH);
		
		//PATH TEMPORÁRIO
		temppath = "";
		
		//insere a imagem
		b1.addActionListener(e -> {
			path = shownavigator();
			JPanel nova = getImage(path); //primeiro temos que fazer isto
			image = nova;  // a imagem fica guardada
			String[] partes = path.split("/");
			for (int i = 0; i < partes.length-1; i++) {
				temppath += "/" + partes[i];
			}
			temppath += "/.temp.bmp"; 
			try {
				RandomAccessFile temp = new RandomAccessFile(temppath, "rw");
				BitmapUtils.createCopy(temp);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.add(image, BorderLayout.CENTER);
			SwingUtilities.updateComponentTreeUI(frame);
		});
		
		//muda o tamanho da imagem
		b2.addActionListener(e -> {
			RandomAccessFile smaller;
			try {
				smaller = new RandomAccessFile(temppath, "rw");
				BitmapUtils.createSmaller(smaller);
				frame.remove(image);
				frame.add(getImage(temppath), BorderLayout.CENTER);
				SwingUtilities.updateComponentTreeUI(frame);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		//roda verticalmente
		b3.addActionListener(e -> {
			RandomAccessFile flipped;
			try {
				flipped = new RandomAccessFile(temppath, "rw");
				BitmapUtils.createVerticalFlip(flipped);
				frame.remove(image);
				frame.add(getImage(temppath), BorderLayout.CENTER);
				SwingUtilities.updateComponentTreeUI(frame);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		//roda horizontalmente
		b4.addActionListener(e -> {
			RandomAccessFile flipped;
			try {
				flipped = new RandomAccessFile(temppath, "rw");
				BitmapUtils.createHorizontalFlip(flipped);
				frame.remove(image);
				frame.add(getImage(temppath), BorderLayout.CENTER);
				SwingUtilities.updateComponentTreeUI(frame);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		//atualizar imagem
		b5.addActionListener(e -> {
			RandomAccessFile copia;
			try {
				copia = new RandomAccessFile(temppath, "r");
				try {
					fileToImage(copia);
					RandomAccessFile toSave = new RandomAccessFile(path, "rw");
					BitmapUtils.createCopy(toSave);
				} catch (IOException ex) {
				    System.err.format("I/O Error when copying file");
				}
				JOptionPane.showMessageDialog(null,"Imagem salva");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null,"Erro!");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null,"Erro!");
			}
		});
		
		//salvar copia
		b6.addActionListener(e -> {
			RandomAccessFile copia;
			try {
				copia = new RandomAccessFile(temppath, "r");

				Path sourceFile = Paths.get(temppath);
				JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				chooser.setDialogType(JFileChooser.SAVE_DIALOG);
				String newpath = "";
				    final int fd = chooser.showDialog(null, "Select folder to save.");

				    if (fd == JFileChooser.APPROVE_OPTION) {
				    	newpath = chooser .getSelectedFile() + ".bmp";
				    } else {
				    	JOptionPane.showMessageDialog(null,"Erro! Caminho inválido.");
				    }
				
				Path targetFile = Paths.get(newpath);
				
				try {
				    //Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
					fileToImage(copia);
					RandomAccessFile toSave = new RandomAccessFile(newpath, "rw");
					BitmapUtils.createCopy(toSave);
					
					
					
				} catch (IOException ex) {
				    System.err.format("I/O Error when copying file");
				}
				JOptionPane.showMessageDialog(null,"Imagem salva");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null,"Erro!");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null,"Erro!");
			}
		});

		frame.setVisible(true);
	}
	
	//mostra o navegador de ficheiros
	public String shownavigator() {
		//navegador de ficheiros
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", "bmp");
		chooser.setFileFilter(filter);
		int returnValue = chooser.showOpenDialog(null);
		 //int returnValue = chooser.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			return selectedFile.getAbsolutePath();
			//frame.add(createPanelImage(frame));
			//image = new File(selectedFile.getAbsolutePath());
		}
		return "";
	}
	
	//retorna panel com a imagem
	public JPanel getImage(String filename) {
		
		try( RandomAccessFile imageFile = new RandomAccessFile(filename, "r") ) {
				
			// read headers
		   Bitmap.bitmapFileHeader = new BitmapFileHeader(imageFile);
		   Bitmap.bitmapInfoHeader = new BitmapInfoHeader(imageFile);
			    
		   // extração do "pixel data"
		   byte[] pixelData = new byte[((Bitmap.bitmapInfoHeader.width+3)*Bitmap.bitmapInfoHeader.height)*3]; 
		   int size = 0;
		   try {
			   size = imageFile.read(pixelData);
		   } catch (EOFException ex) {
				System.out.println(filename + ".bmp lido.");
		   } finally {
				Bitmap.data = new byte[size];
				System.arraycopy(pixelData, 0, Bitmap.data, 0, size);
		   }	
		} catch(Exception e) {
			System.err.println(e);
		}
		
		JPanel panel = new PanelImage(Bitmap.data, Bitmap.bitmapInfoHeader.width, Bitmap.bitmapInfoHeader.height);
		return panel;
	}
	
	public JPanel fileToImage (RandomAccessFile imageFile) throws IOException {
		
		// read headers
		Bitmap.bitmapFileHeader = new BitmapFileHeader(imageFile);
		Bitmap.bitmapInfoHeader = new BitmapInfoHeader(imageFile);
			    
		//extração do "pixel data"
		byte[] pixelData = new byte[((Bitmap.bitmapInfoHeader.width+3)*Bitmap.bitmapInfoHeader.height)*3]; 
		int size = 0;
		try {
			size = imageFile.read(pixelData);
		} catch (EOFException ex) {
			//System.out.println(filename + ".bmp lido.");
		} finally {
			Bitmap.data = new byte[size];
			System.arraycopy(pixelData, 0, Bitmap.data, 0, size);
		}
		
		JPanel panel = new PanelImage(Bitmap.data, Bitmap.bitmapInfoHeader.width, Bitmap.bitmapInfoHeader.height);
		return panel;
	}
	
}