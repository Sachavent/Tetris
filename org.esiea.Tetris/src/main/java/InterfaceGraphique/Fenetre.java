package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fenetre {
	
	// DEFINIT NOMBRE LIGNE ET COLONNE DU TETRIS
	public static int NUM_COL_TETRIS=10;
	public static int NUM_LIGNE_TETRIS=20;
	
	public void creationfenetre() {
		
		//Cr�ation fenetre
		JFrame fenetre = new JFrame();
		
		// On cr�e un nouveau Board
	    fenetre.getContentPane().add(new Board());
	    
	    //Affiche la fenetre
	    fenetre.setSize(400,500);
		fenetre.setVisible(true);
	
		
	}
	
	
	
}
