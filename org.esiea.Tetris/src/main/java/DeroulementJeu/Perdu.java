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
	
	// Fonction qui permet d'indiquer le résultat de la partie
	public static void setLoose(boolean result) {
		perdu=result;
	}
	
	public static void testDefaite(int [][]Board, int[][] piececourante,int[] positionpiececourante, int rotationcourante) {
	  	int compteur=0;		
		for (int i=positionpiececourante[0]; i < positionpiececourante[0]+4; i++) {
			for (int j=positionpiececourante[1]; j < positionpiececourante[1]+4; j++) {
				if (compteur < 16) {
				if (piececourante[rotationcourante][compteur]>0 && Board[i][j] > 0) {
					Perdu.setLoose(true);
				}
				}
				compteur++;
				}
		}	
	
	}
	
}
