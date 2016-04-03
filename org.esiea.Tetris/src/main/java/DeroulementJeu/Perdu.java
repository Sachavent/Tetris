package DeroulementJeu;

import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;

public class Perdu {

	// Tant que c'est false c'est que l'utilisateur n'a pas perdu
	private static boolean perdu=false;
	
	// Fonction qui indique si l'utilisateur a perdu ou non
	public static boolean isItLoose() {
		return perdu;
	}
	
	// Fonction qui permet d'indiquer le r�sultat de la partie
	public static void setLoose(boolean result) {
		perdu=result;
	}
	
	public static void testDefaite(int [][]Board, int[][] piececourante) {
	  	int compteur=0;		
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				if (compteur < 16) {
				if (piececourante[Pieces.rotation_piececourante][compteur]>0 && Board[i][j] > 0) {
					Perdu.setLoose(true);
				}
				}
				compteur++;
				}
		}	
	
	}
	
}
