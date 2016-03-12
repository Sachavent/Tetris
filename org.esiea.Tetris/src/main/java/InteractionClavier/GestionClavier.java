package InteractionClavier;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// Classe g�rant tous les inputs claviers
// Est appel� dans la classe Fenetre
public class GestionClavier implements KeyListener{

	// S'execute quand on appuie sur une touche
	public void keyPressed(KeyEvent e) {
		
		// Quand on appuie sur la touche du haut
		if (e.getKeyCode()== KeyEvent.VK_UP) {
			// On souhaite faire tourner les pieces
		System.out.println("Touche appuy�e: HAUT");
		}
		
		// Quand on appuie sur la touche gauche
		if (e.getKeyCode()== KeyEvent.VK_LEFT) {
			// On souhaite un d�placement de la piece vers la gauche
			System.out.println("Touche appuy�e: GAUCHE");	
		}
		
		//Quand on appuie sur la fleche droite
		if (e.getKeyCode()== KeyEvent.VK_RIGHT) {
			// On souhaite deplacer la piece vers la droite
			System.out.println("Touche appuy�e: DROITE");
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
