package DeroulementJeuTest;

import static org.junit.Assert.*;

import org.junit.Test;

import DeroulementJeu.Perdu;

public class PerduTest {

	private int[][] plateau={
			{1,0,0,0},
			{0,0,0,0},
			{1,1,1,1},
			{0,1,3,0}
	};;
	
	private int[][] Piece={ {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };
	private int[] position_courante= new int[2];
	
	@Test
	public void shouldloose() {
		position_courante[0]=0;
		position_courante[1]=0;
		boolean isitperdu=false;
		// Indique qu'on a perdu
		Perdu.testDefaite(plateau, Piece,position_courante, 0);
		isitperdu=Perdu.isItLoose();
		assertEquals(true,isitperdu);
	}
	
	

}