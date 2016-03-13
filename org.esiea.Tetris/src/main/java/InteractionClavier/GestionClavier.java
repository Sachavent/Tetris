package InteractionClavier;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import DeroulementJeu.Deroulement;
import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;


// Classe g�rant tous les inputs claviers
// Est appel� dans la classe Fenetre
public class GestionClavier implements KeyListener{

	// S'execute quand on appuie sur une touche
	public void keyPressed(KeyEvent e) {
		////////////////////////////////////////////////////// TOUCHE HAUT ///////////////////////////////
		// Quand on appuie sur la touche du haut
		if (e.getKeyCode()== KeyEvent.VK_UP) {
			// On souhaite faire tourner les pieces
		
		}
		
		
		/////////////////////////////////////////////// TOUCHE GAUCHE ///////////////////////////////////////
		
		// Quand on appuie sur la touche gauche
		if (e.getKeyCode()== KeyEvent.VK_LEFT) {
			// On souhaite un d�placement de la piece vers la gauche
		  	int compteur=0;
		  	int mincol=0;
			for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
				for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
					if (compteur < 16) {
						if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && compteur%4<mincol) {
							// Le min corresponds � l'indice de la colonne le plus � gauche de la piece courante
							mincol=compteur%4;
						}
					}
					compteur++;
					
					}
			}
			// On s'assure que la piece ne sort pas � droite du plateau
			// De plus on s'assure qu'il n'y a pas d�j� une piece du plateau
			if (Pieces.position_piececourante[1]-mincol+1 > 0) {
				// Maintenant qu'on s'est assur� que la piece ne sort pas du tableau
				// il faut v�rifi� qu'elle n'est pas bloqu�e
				if (bloquegauche()==false) {
				Pieces.position_piececourante[1]--;
				}
			}
			
		}
		
		//////////////////////////////////////////////////////// TOUCHE DROITE ////////////////////////////////
		
		//Quand on appuie sur la fleche droite
		if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
			// On souhaite un d�placement vers la droite
		  	int compteur=0;
		  	int maxcol=0;
			for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
				for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
					if (compteur < 16) {
						if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && compteur%4>maxcol) {
							// Le max corresponds � l'indice de la colonne le plus � droite de la piece courante
							maxcol=compteur%4;
						}
					}
					compteur++;
					
					}
			}
			// On s'assure que la piece ne sort pas � droite du plateau
			// De plus on s'assure qu'il n'y a pas d�j� une piece du plateau
			if (Pieces.position_piececourante[1]+maxcol+1 < Fenetre.NUM_COL_TETRIS) {
				// Maintenant qu'on s'est assur� que la piece ne sort pas du tableau
				// il faut v�rifi� qu'elle n'est pas bloqu�e
				if (bloquedroite()==false) {
				Pieces.position_piececourante[1]++;
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean bloquedroite() {
		int compteur=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]+1; j < Pieces.position_piececourante[1]+5; j++) {
				if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && Deroulement.Board[Pieces.position_piececourante[0]+(compteur/4)][Pieces.position_piececourante[1]+(compteur%4)+1] > 0) {
					return true; 
				}
				compteur++;
			}
		
		}	
		return false;
	}
	
	public static boolean bloquegauche() {
		int compteur=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]-1; j < Pieces.position_piececourante[1]+3; j++) {
				
				if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && Deroulement.Board[Pieces.position_piececourante[0]+(compteur/4)][Pieces.position_piececourante[1]-1+(compteur%4)] > 0) {
					return true; 
				}
				compteur++;
			}
		
		}	
		return false;
	}

}
