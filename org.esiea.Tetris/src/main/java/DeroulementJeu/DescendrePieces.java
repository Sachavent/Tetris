package DeroulementJeu;

import InterfaceGraphique.Fenetre;
import Launcher.Launcher;

public class DescendrePieces {

	public static void launch() {
		while (Launcher.finit==false) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// On cr�e un tableau temporaire pour eviter de supprimer des bouts de piece 
		int [][] temp = new int [Fenetre.NUM_LIGNE_TETRIS][Fenetre.NUM_COL_TETRIS];
		
		for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++) {
			for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
				// test important pour �viter les erreurs m�moires
				if (i>0) {
				temp[i][j]=Deroulement.Board[i-1][j];
				}
				
			}
		}
		Deroulement.setBoard(temp);
	}
	}
}
