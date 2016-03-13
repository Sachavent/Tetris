package DeroulementJeu;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

import GestionFichier.Pieces;
import InteractionClavier.GestionClavier;
import InterfaceGraphique.Fenetre;
import InterfaceGraphique.RenderBoard;

// Cest la fonction qui va gérer le tableau

public class Deroulement {
	
	public static int[][] Board;
	private Fenetre fenetre;
	private Pieces piece_tetris;
	private int choose_random_piece;
	public static int[][] piece_courante;
	

		// Fonction qui sert à initialiser le jeu
		public void initialise() {
			
			System.out.println("initialisation du jeu...");
			// Crée le plateau de jeu
			Board= new int[Fenetre.NUM_LIGNE_TETRIS][Fenetre.NUM_COL_TETRIS];
			
			// Permet d'initialiser l'interface graphique
			fenetre= new Fenetre();
			fenetre.creationfenetre();		
			
			
			////////////////////////////////////////////// Lance le premier tour du jeu //////////////////////
			// Charge une premiere piece
			piece_tetris= new Pieces();
			
			// On choisit un nombre aléatoire parmi les pieces existantes afin de choisir le numero de la piece a créer
			int choose_random_piece = randomInt(1 ,Pieces.NOMBRE_PIECE);
			piece_courante = piece_tetris.create_piece(choose_random_piece);
			/*for (int i=0; i < 20; i++) {
				for (int j=0; j < 20; j++) {
					
					Deroulement.Board[i][j]=0;
					
					}
			
			}*/
			
			
			///////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			// On crée un thread pour la descente des pieces car elle se fait en parallèle du jeu
			final DescendrePieces descendre= new DescendrePieces();
			Runnable descente= new Runnable () {
				public void run() {
							descendre.launch();
				}
			};
			
			// On lance le thread pour la descente des pieces
			 
			Thread t_descente = new Thread (descente);
			 t_descente.start();
		}  
		
		
		//////////////////////////////////////////////////////////////
		// Fonction qui sera réactualisé au cours du temps
		public void run() {
			
			// Flag provenant de descendre piece
			if (DescendrePieces.create_new_piece==true){
				System.out.println("");
				System.out.println("tableau reçut: ");
				for (int i=0; i < Fenetre.NUM_LIGNE_TETRIS; i++ ) {
					System.out.println("");
					for (int j=0; j < Fenetre.NUM_COL_TETRIS; j++) {
						System.out.print(Board[i][j]);
					}
				}
				
				// On réinitialise la position pour la nouvelle piece
				Pieces.position_piececourante[0]=0;
				Pieces.position_piececourante[1]=3;
				
				// On recrée une nouvelle piece
				int choose_random_piece = randomInt(1 ,Pieces.NOMBRE_PIECE);
				piece_courante = piece_tetris.create_piece(choose_random_piece);
				// On remet le flag à false
				DescendrePieces.create_new_piece=false; 
			}
		

		}
		
		// Fonction qui permet de retourner un nombre aléatoire entre 0 et Nombre de piece
		public static int randomInt (int minimum, int maximum) {
			Random random= new Random();
			int randomInteger= random.nextInt((maximum-minimum)+1)+minimum;
			
			return randomInteger;
		}
				
		// Fonction qui retourne le tableau (important pour l'intéraction avec la classe interface graphique)
		// On envoie le tableau au package interface graphique afin que celui ci soit afficher
		public static int [][] getBoard() {
			return Board;
		}
		
		// Permet de modifier le plateau de jeu d'autres classe (utile pour la classe Descendre Piece)
		public static void setBoard(int [][] plateau) {
			Board=plateau;
		}
		
}
