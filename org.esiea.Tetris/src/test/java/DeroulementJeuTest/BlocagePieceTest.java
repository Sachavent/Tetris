package DeroulementJeuTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeroulementJeu.BlocagePieces;
import DeroulementJeu.Deroulement;
import GestionFichier.Pieces;

public class BlocagePieceTest {
	private int rotation;
	private int[] position_courante= new int[2];
	private int[][]plateau= new int [20][20];
	private int[][] Piece={ {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };

	
	@Test
	public void shouldreturnfalseforBloquedroite() {
		position_courante[0]=0;
		position_courante[1]=15;
		boolean retour;
		retour=BlocagePieces.bloquedroite(position_courante,rotation,plateau, Piece);
		assertEquals(false,retour);
	}
	
	@Test
	public void shouldreturnfalseforBloquegauche() {
		position_courante[0]=0;
		position_courante[1]=10;
		boolean retour;
		retour=BlocagePieces.bloquegauche(position_courante,rotation,plateau, Piece);
		assertEquals(false,retour);
	}
	
	@Test
	public void shouldreturnfalseforRotationbloque() {
		boolean retour;
		retour=BlocagePieces.rotationblocked(rotation, plateau,Piece);
		assertEquals(false,retour);
	}
	

}
