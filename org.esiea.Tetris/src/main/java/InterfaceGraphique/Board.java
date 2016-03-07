package InterfaceGraphique;

import java.awt.Graphics;

import javax.swing.JComponent;

import GestionFichier.Pieces;

public class Board extends JComponent {
	  private int pas_vertical;
	  private int pas_horizontal;
	  private int width_rect;
	  private int height_rect;
	  public int[][] Board;
	  

	  
	  public void paint(Graphics g) {
		  	// Initialisation des variables.
			pas_vertical=0;
		  	pas_horizontal=0;
		  	width_rect=20;
		  	height_rect=20;
		  	Board= new int[Fenetre.NUM_LIGNE_TETRIS][Fenetre.NUM_COL_TETRIS];
		  	
		  	// EXEMPLE DE PIECE
		  	Board[1][3]=0;
		  	Board[1][4]=5;
		  	Board[1][5]=0;
		  	Board[1][6]=0;
		  	Board[2][3]=0;
		  	Board[2][4]=5;
		  	Board[2][5]=5;
		  	Board[2][6]=0;
		  	Board[3][3]=0;
		  	Board[3][4]=5;
		  	Board[3][5]=0;
		  	Board[3][6]=0;
		  	Board[4][3]=0;
		  	Board[4][4]=0;
		  	Board[4][5]=0;
		  	Board[4][6]=0;
		  	
		 // Dessine le plateau
		  	for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++) {
		  		// Quand il y a un retour � la ligne (On indique qu'il faut changer la valeur du Y)
		  		pas_vertical+=height_rect;
		  		pas_horizontal=0;
		  		
		  		for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
		  			//On se d�place sur les colonnes donc on on fait un pas de la largeur du rectangle
		  			g.drawRect ((40+pas_horizontal), (30+pas_vertical), width_rect, height_rect);
		  			
		  			// Si la case est pleine
		  			if (Board[i][j]>0) {
		  				// Alors on "remplit" la case
		  				fill_case(g,i,j,width_rect, height_rect);
		  			}
		  			pas_horizontal+=width_rect;
		  		}
		  	}
	
		  	//avancetour(g,3,3,width_rect, height_rect);
		     
	  }
	  
	  // Fonction permettant de dire qu'une case est occup�e
	  public void fill_case(Graphics g,int ligne, int col, int width_rect, int height_rect) {
		  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
	  }
	  
	  // Fonction permettant d'avancer d'un "tour" (faire descendre les pieces d'une ligne)
	  public void avancetour(Graphics g,int ligne, int col, int width_rect, int height_rect) {
		  
		  repaint();
		  g.fillRect(40+(width_rect*(col)), 30+(height_rect*(ligne+1)), width_rect, height_rect);
		  
	  }

}
