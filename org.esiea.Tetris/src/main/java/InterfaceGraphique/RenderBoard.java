package InterfaceGraphique;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import DeroulementJeu.Deroulement;
import GestionFichier.Pieces;

// C'est la fonction qui s'occupe uniquement de l'affichage
// La fonction est appel� dans la classe d�roulement
// Cette classe est appel� d�s qu'on a besoin d'update l'affichage
public class RenderBoard extends JComponent {
	  private int pas_vertical;
	  private int pas_horizontal;
	  private int width_rect;
	  private int height_rect;
	  public int[][] plateau;

	  
	  public void paint(Graphics g) {
		  	// Initialisation des variables.
			pas_vertical=0;
		  	pas_horizontal=0;
		  	width_rect=20;
		  	height_rect=20;
		  	plateau= Deroulement.getBoard();
		  	
		  	//UTILE POUR LES TESTS
		  	g.setColor(new Color(0,192,0)); 
		  	fill_case(g,Pieces.position_piececourante[0],Pieces.position_piececourante[1]+3,width_rect, height_rect);
		  	g.setColor(Color.pink);  
		  	fill_case(g,Pieces.position_piececourante[0],Pieces.position_piececourante[1],width_rect, height_rect);
		  	 g.setColor(new Color(0,128,224));
		 // Dessine piece courante
		  	int compteur=0;		
			for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
				for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
					if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0) {
						fill_case(g,i,j,width_rect, height_rect);
					}
					}
					compteur++;
					}
			}

		  	
		 // Dessine le plateau
		  	for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++) {
		  		// Quand il y a un retour � la ligne (On indique qu'il faut changer la valeur du Y)
		  		if (i>0) {
		  		pas_vertical+=height_rect;
		  		pas_horizontal=0;
		  		}
		  		for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
		  			//On se d�place sur les colonnes donc on on fait un pas de la largeur du rectangle
		  			g.drawRect ((40+pas_horizontal), (30+pas_vertical), width_rect, height_rect);
		  			
		  			// Si la case est pleine
		  			if (plateau[i][j]>0) {
		  				// Alors on "remplit" la case
		  				
		  				fill_case(g,i,j,width_rect, height_rect);
		  			}
		  			pas_horizontal+=width_rect;
		  		}
		  	}
		  	
		  	// raffiche le contenu du Tetris quand il y a un UPDATE du Board
		  	repaint();
		     
	  }
	  
	  // Fonction permettant de dire qu'une case est occup�e
	  public void fill_case(Graphics g,int ligne, int col, int width_rect, int height_rect) {
		  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
	  }
}