package DeroulementJeu;

import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;
import Launcher.Launcher;

public class DescendrePieces {
	
	// Classe qui g�re la descente des pieces
	
	private static boolean flag_onemorezero=false;
	public static boolean create_new_piece;
	// Valeur qui indique de combien de ligne max on peut augmenter sans quitter le plateau
	public static void launch() {
		while (Launcher.finit==false) {
		try {
			// Descend le plateau toute les seconde
			// 1000 == 1 seconde
			Thread.sleep(200);
			
			// On appelle la fonction qui supprime les lignes en cas de besoin
			suppressionLignePlateau();


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Permet de conna�tre l'indice de la piece la plus en bas.
	  	int compteur=0;
	  	int maxligne=0;
		for (int i=Pieces.position_piececourante[0]; i < Pieces.position_piececourante[0]+4; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				if (compteur < 16) {
					if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && compteur/4>maxligne) {
						// Le min corresponds � l'indice de la colonne le plus en bas de la piece courante
						maxligne=compteur/4;
					}
				}
				compteur++;
				
				}
		}

		
		// On regarde si  la piece sort du plateau quand elle avance
		// Si oui, alors on l'int�gre au board et on cr�e une nouvelle piece
		if (Pieces.position_piececourante[0]+maxligne+2 > Fenetre.NUM_LIGNE_TETRIS ) {
		  	compteur=0;		
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
			// Cr�er une nouvelle piece correspond � "supprimer" la piece courante
			create_new_piece=true;
			// On incr�mente la position s'il n'y a pas de probl�me...
		} else {
			// Retour false, indique que la piece n'est pas bloqu�
			if (bloqueparboard()==false) {
				 Pieces.position_piececourante[0]+=1;
				
			} else {
				// alors la piece est bloqu�! Il faut donc cr�er une nouvelle piece!
				// Il faut �galement int�grer la pi�ce courante au board.
			  	compteur=0;		
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
			}
			
		}				

	}
	}
	
	// Fonction qui s'assure qu'on peut descendre la piece
	public static boolean bloqueparboard() {
		int compteur=0;
		// Attention dans la boucle on suppose que la piece avance vers le bas ( +1 au numero de ligne)
		for (int i=Pieces.position_piececourante[0]+1; i < Pieces.position_piececourante[0]+5; i++) {
			for (int j=Pieces.position_piececourante[1]; j < Pieces.position_piececourante[1]+4; j++) {
				if (Deroulement.piece_courante[Pieces.rotation_piececourante][compteur]>0 && Deroulement.Board[Pieces.position_piececourante[0]+(compteur/4)+1][Pieces.position_piececourante[1]+(compteur%4)] > 0) {
					return true; 
				}
				compteur++;
			}
		
		}
		
		return false;
	}
	
	
	// Fonction qui supprime ligne du tableau
	public static void suppressionLignePlateau() {
		// On initialise un compteur
		// Si une case > 0 alors on incr�mente le compteur
		// Si le compteur == au nombre de colonne du Tetris alors la ligne est remplie (donc suppression -> remise des valeurs � 0)
		
		
		int compteur=0;
		for (int ligne=0; ligne < Fenetre.NUM_LIGNE_TETRIS; ligne ++) {
			for (int col=0; col < Fenetre.NUM_COL_TETRIS; col ++) {
				if (Deroulement.Board[ligne][col]>0) {
					// On incr�mente le compteur quand la case n'est pas vide
					compteur++;                                                     
				}
				
			}
			
			// si compteur == nombre de colonne -> alors la ligne est remplie donc il faut la supprimer
			if (compteur == Fenetre.NUM_COL_TETRIS){
				for (int colbis=0; colbis < Fenetre.NUM_COL_TETRIS; colbis++) {					
					// supprime la ligne
					Deroulement.Board[ligne][colbis]=0;
				}
				// On descent le reste du plateau � partir de la ligne supprim�
				descendreplateau(ligne);
			} 
			// ATTENTION: il ne faut pas oublier de remettre le compteur � 0
			compteur=0;
		}
	}
	
	// Fonction permettant de descendre le plateau d'une ligne (quand il y a suppression d'une ligne)
	public static void descendreplateau(int lignesuppress) {
		
		// On cr�e un tableau temporaire entre la ligne 0 et la ligne supprim�e
		int temp[][]= new int [lignesuppress+1][Fenetre.NUM_COL_TETRIS];
		for (int i=0; i < lignesuppress+1; i++) {
			for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
				if (i==0) {
					temp[1][j]=Deroulement.Board[0][j];
				}
				if (i-1 > 0) {
					//On d�calle le board dans le tableau temp
					temp[i][j]=Deroulement.Board[i-1][j];
				}
				
			}
		}

		// Enfin, on enregistre les valeurs du tableau temp dans le Board 
		// ATTENTION : quand on enregistre les valeurs, on va jusqu'� lignesupress+1 (et pas nombre de ligne)
		for (int i=0; i < lignesuppress+1; i ++) {
			for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
				Deroulement.Board[i][j]=temp[i][j];
			}
		}

		
	}
	
	
}
