package InterfaceGraphique;

import java.awt.Graphics;

import javax.swing.JComponent;

public class Board extends JComponent {
  
	  public void paint(Graphics g) {
		  	// Dessine le plateau
			int pas_vertical=0;
		  	int pas_horizontal=0;
		  	int width_rect=20;
		  	int height_rect=20;
		  
		  	for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++) {
		  		pas_vertical+=height_rect;
		  		pas_horizontal=0;
		  		for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
		  			g.drawRect ((40+pas_horizontal), (30+pas_vertical), width_rect, height_rect);
		  			pas_horizontal+=width_rect;
		  		}
		  	}

		    //g.fillRect(40+(width_rect*3), 30+(height_rect*3), width_rect, height_rect);
		  	fill_case(g,3,3,width_rect, height_rect);
		     
	  }
	  
	  public void fill_case(Graphics g,int ligne, int col, int width_rect, int height_rect) {
		  g.fillRect(40+(width_rect*ligne), 30+(height_rect*col), width_rect, height_rect);
	  }

}