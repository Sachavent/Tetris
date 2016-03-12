package GestionFichier;

import DeroulementJeu.Deroulement;

// Cest la classe qui s'occupe des pieces
// Elle est appel� dans la classe D�roulement

public class Pieces {
	// Constante correspondant au nombre de piece, utile pour g�n�rer un random
	public final static int NOMBRE_PIECE=2;
	// Position initial de la place
	public static int[] position_piececourante= {0,3};
	// Indique la rotation actuelle dans laquelle se trouve la piece
	public static int rotation_piececourante=0;
	// Cr�ation des pieces, cod� sur des cases 4x4
	// Chaque piece poss�de d�j� les "valeurs" de sa rotation donc pas besoin de g�rer les rotations de fa�on manuelle
	int[][] Piece1 = { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };
	int[][] Piece2 = { {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},{0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0} };
	
	// Fonction appel� dans la classe Deroulement afin de cr�er une nouvelle piece
	public int[][] create_piece(int numberpiece) {

		switch (numberpiece) {
		case 1:
			return Piece1;
		case 2:
			return Piece2;
		default: return null;
		}
	}
	
	
	// Get avec le num�ro de la piece qu'on souhaite afficher
	public int[][] get_piece (int numberpiece){
		switch (numberpiece) {
		case 1:
			return Piece1;
		case 2:
			return Piece2;
		default: return null;
		}
		
	}

	
}
