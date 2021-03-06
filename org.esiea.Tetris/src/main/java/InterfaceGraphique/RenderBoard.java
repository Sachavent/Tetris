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
	  private int[][]piececourante;
	  private int numpiece;

	  
	  public void paint(Graphics g) {
		  	// Initialisation des variables.
			pas_vertical=0;
		  	pas_horizontal=0;
		  	width_rect=20;
		  	height_rect=20;
		  	

		  	
		 // Dessine piece courante
		  	piececourante=Deroulement.getpiece_courante();
		  	numpiece=Deroulement.getnumeropiece();
		  	int compteur=0;		
			for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
				for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
					if (compteur < 16) {
					if (piececourante[Pieces.rotation_piececourante][compteur]>0) {
						fill_case(g,i,j,width_rect, height_rect,numpiece);
					}
					}
					compteur++;
					}
			}

		  	for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++) {
		  		// Quand il y a un retour � la ligne (On indique qu'il faut changer la valeur du Y)
		  		if (i>0) {
		  		pas_vertical+=height_rect;
		  		pas_horizontal=0;
		  		}
		  		for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
		  			//On se d�place sur les colonnes donc on on fait un pas de la largeur du rectangle
		  			 g.setColor(Color.BLACK);
		  			g.drawRect ((40+pas_horizontal), (30+pas_vertical), width_rect, height_rect);
		  			// Si la case est pleine
		  			if (Deroulement.Board[i][j]>0) {
		  				// Alors on "remplit" la case
		  				fill_case(g,i,j,width_rect, height_rect,Deroulement.Board[i][j]);
		  			}
		  			pas_horizontal+=width_rect;
		  		}
		  	}
		  	
		  	// raffiche le contenu du Tetris quand il y a un UPDATE du Board
		  	repaint();
		     
	  }
	  
	  // Fonction remplissant la case si elle est occup�
	  
	  public void fill_case(Graphics g,int ligne, int col, int width_rect, int height_rect, int valeurforswitch) {
		  
		  switch (valeurforswitch) {
		  case 1:
			  g.setColor(Color.BLACK);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return;
		  case 2:
			  g.setColor(Color.BLUE);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return;
		  case 3:
			  g.setColor(Color.RED);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return;
		  case 4:
			  g.setColor(Color.GREEN);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return; 
		  case 5:
			  g.setColor(Color.PINK);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return;
		  case 6:
			  g.setColor(Color.CYAN);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return;
		  case 7:
			  g.setColor(Color.DARK_GRAY);
			  g.fillRect(40+(width_rect*col), 30+(height_rect*ligne), width_rect, height_rect);
			  g.setColor(Color.BLACK);
			  g.drawRect ((40+width_rect*col), (30+height_rect*ligne), width_rect, height_rect);
			  return;
		  
		  }
		  
	  }
	  
}
