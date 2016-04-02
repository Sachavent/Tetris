package InterfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DeroulementJeu.Deroulement;
import DeroulementJeu.Score;
import InteractionClavier.GestionClavier;


// Est appel� dans la classe D�roulement pour l'initialisation du jeu
public class Fenetre {
	
	// DEFINIT NOMBRE LIGNE ET COLONNE DU TETRIS
	public static int NUM_COL_TETRIS=10;
	public static int NUM_LIGNE_TETRIS=20;
	private static JFrame fenetre;
	private static int[] tableauscore;
	public void creationfenetre() {
		
		//Cr�ation fenetre
		fenetre = new JFrame();
		
		///////////////////////////////////////////// AJOUTE LINTERACTION CLAVIER //////////////////////
		// On ajoute un Keylistener 
		fenetre.addKeyListener(new GestionClavier());
		
		// On cr�e un nouveau Board
		// Affiche le tableau pour les test
	    fenetre.getContentPane().add(new RenderBoard());
	    
	    //Affiche la fenetre
	    fenetre.setSize(800,500);
		fenetre.setVisible(true);
	}
	
	public void afficheFinPartie() {
		tableauscore=Score.getTableauScore();
		
		JOptionPane.showMessageDialog(fenetre, "Game Over \nVotre score: "+ Score.getScore()+ "\nMeilleurs Scores:\n" +Arrays.toString(tableauscore));
	}
	
	
	
}
