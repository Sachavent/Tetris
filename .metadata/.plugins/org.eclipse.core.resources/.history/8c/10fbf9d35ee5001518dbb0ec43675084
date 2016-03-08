package GestionFichierTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GestionFichier.Pieces;

public class PiecesTest {

	private Pieces pieces;
	
	@Before
	public void allocation(){
		pieces= new Pieces();
	}
	
	// Test pour vérifier l'exactitude de la piece 5
	@Test
	public void shouldReturnPiece5() {
		int [][] Piece5={ {0,5,0,0,0,5,5,0,0,5,0,0,0,0,0,0},{0,0,0,0,0,0,5,0,0,5,5,5,0,0,0,0},{0,0,0,5,0,0,5,5,0,0,0,5,0,0,0,0},{0,5,5,5,0,0,5,0,0,0,0,0,0,0,0,0} };
		assertEquals(pieces.getPiece5(),Piece5);
	}


}
