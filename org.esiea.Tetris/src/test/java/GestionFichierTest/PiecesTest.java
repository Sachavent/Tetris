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
	
	// Test pour v�rifier l'exactitude de la piece 1
	@Test
	public void shouldReturnPiece1() {
		int[][] Piece1 = { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };
		assertEquals(Piece1,pieces.create_piece(1));
		
	}
	@Test
	public void shouldReturnPiece2() {
		int[][] Piece2 = { {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},{0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0} };
		assertEquals(Piece2,pieces.create_piece(2));
		
	}
	@Test
	public void shouldReturnPiece3() {
		int[][] Piece3 = { {0,0,3,0,0,3,3,0,0,3,0,0,0,0,0,0},{0,0,0,0,0,3,3,0,0,0,3,3,0,0,0,0},{0,0,3,0,0,3,3,0,0,3,0,0,0,0,0,0},{0,0,0,0,0,3,3,0,0,0,3,3,0,0,0,0} };
		assertEquals(Piece3,pieces.create_piece(3));
		
	}
	@Test
	public void shouldReturnPiece4() {
		int[][] Piece4 = { {0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0},{0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0},{0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0},{0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0} };
		assertEquals(Piece4,pieces.create_piece(4));
		
	}
	@Test
	public void shouldReturnPiece5() {
		int[][] Piece5 = { {0,5,0,0,0,5,5,0,0,0,5,0,0,0,0,0},{0,0,0,0,0,0,5,5,0,5,5,0,0,0,0,0},{0,5,0,0,0,5,5,0,0,0,5,0,0,0,0,0},{0,0,0,0,0,0,5,5,0,5,5,0,0,0,0,0} };
		assertEquals(Piece5,pieces.create_piece(5));
		
	}
	@Test
	public void shouldReturnPiece6() {
		int[][] Piece6 = { {0,0,6,0,0,0,6,0,0,6,6,0,0,0,0,0},{0,0,0,0,0,6,6,6,0,0,0,6,0,0,0,0},{0,6,6,0,0,6,0,0,0,6,0,0,0,0,0,0},{0,0,0,0,0,6,0,0,0,6,6,6,0,0,0,0} };
		assertEquals(Piece6,pieces.create_piece(6));
		
	}
	@Test
	public void shouldReturnPiece7() {
		int[][] Piece7 = { {0,7,0,0,0,7,0,0,0,7,7,0,0,0,0,0},{0,0,0,0,0,0,0,7,0,7,7,7,0,0,0,0},{0,7,7,0,0,0,7,0,0,0,7,0,0,0,0,0},{0,0,0,0,0,7,7,7,0,7,0,0,0,0,0,0} };
		assertEquals(Piece7,pieces.create_piece(7));
		
	}


}
