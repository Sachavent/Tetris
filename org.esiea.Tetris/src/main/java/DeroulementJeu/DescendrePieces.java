package DeroulementJeu;

import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;
import Launcher.Launcher;

public class DescendrePieces {
	private static boolean flag_onemorezero=false;
	public static boolean create_new_piece;
	// Valeur qui indique de combien de ligne max on peut augmenter sans quitter le plateau
	public static void launch() {
		while (Launcher.finit==false) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("Position ligne actuelle: "+Pieces.position_piececourante[0]);
		// On regarde si  la piece sort du plateau quand elle avance
		// Si oui, alors on l'int�gre au board et on cr�e une nouvelle piece
		if (Pieces.position_piececourante[0]+5 > Fenetre.NUM_LIGNE_TETRIS ) {
		  	int compteur=0;		
			for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
				for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
					if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0) {
						Deroulement.Board[i][j]=Deroulement.piece_courante[Pieces.rotation_piececourante][compteur];
					}
					}
					compteur++;
					}
			}
			// Flag pour indiquer qu'il faut cr�er une nouvelle piece
			create_new_piece=true;
			// On incr�mente la position s'il n'y a pas de probl�me...
		} else {Pieces.position_piececourante[0]+=1;	 }

				
				

	}
	}
}
