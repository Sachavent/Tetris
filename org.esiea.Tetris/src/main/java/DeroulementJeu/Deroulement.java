package DeroulementJeu;

import java.util.Random;

import GestionFichier.Pieces;
import InterfaceGraphique.Fenetre;
import InterfaceGraphique.RenderBoard;

// Cest la fonction qui va g�rer le tableau

public class Deroulement {
	
	public static int[][] Board;
	private Fenetre fenetre;
	private Pieces piece_tetris;
	private int choose_random_piece;
	private int[][] piece;

		// Fonction qui sert � initialiser le jeu
		public void initialise() {
			
			System.out.println("initialisation du jeu...");
			// Cr�e le plateau de jeu
			Board= new int[Fenetre.NUM_LIGNE_TETRIS][Fenetre.NUM_COL_TETRIS];
			
			// Permet d'initialiser l'interface graphique
			fenetre= new Fenetre();
			fenetre.creationfenetre();	
			
			// Charge une premiere piece
			piece_tetris= new Pieces();
			
			// On choisit un nombre al�atoire parmi les pieces existantes afin de choisir le numero de la piece a cr�er
			int choose_random_piece = randomInt(1 ,Pieces.NOMBRE_PIECE);
			piece_tetris.create_piece(choose_random_piece);
		}  
		
		
		//////////////////////////////////////////////////////////////
		// Fonction qui sera r�actualis� au cours du temps
		public void run() {
			// Attente de 1 s avant de refresh
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			descendrepiece();
			
		}
		
		public static void descendrepiece() {
			// On cr�e un tableau temporaire pour eviter de supprimer des bouts de piece
			int [][] temp = new int [Fenetre.NUM_LIGNE_TETRIS][Fenetre.NUM_COL_TETRIS];
			
			for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++) {
				for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
					// test important pour �viter les erreurs m�moires
					if (i>0) {
					temp[i][j]=Board[i-1][j];
					}
					
				}
			}
			Board=temp;

		}
		
		// Fonction qui permet de retourner un nombre al�atoire entre 0 et Nombre de piece
		public static int randomInt (int minimum, int maximum) {
			Random random= new Random();
			int randomInteger= random.nextInt((maximum-minimum)+1)+minimum;
			
			return randomInteger;
		}
				
		// Fonction qui retourne le tableau (important pour l'int�raction avec la classe interface graphique)
		public static int [][] getBoard() {
			return Board;
		}

		
}
