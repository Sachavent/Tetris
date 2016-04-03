package DeroulementJeuTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeroulementJeu.SuppressionLigne;

public class SuppressionLigneTest {
	private int[][] plateau={
			{1,0,0,0},
			{0,0,0,0},
			{1,1,1,1},
			{0,1,3,0}
	};;
	private int [][] resultexpected= 
		{
				{1,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,1,3,0}
		};

	@Test
	public void shouldsuppressligne() {
		// Probleme avec Fentre.numLigne et Fenetre.num col
		SuppressionLigne.suppressionLignePlateau(plateau);
		assertArrayEquals(resultexpected, plateau);
	}

}
