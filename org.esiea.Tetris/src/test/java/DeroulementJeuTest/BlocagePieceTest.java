package DeroulementJeuTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeroulementJeu.BlocagePieces;
import GestionFichier.Pieces;

public class BlocagePieceTest {
	private Pieces pieces;
	@Before
	public void allocation(){
		pieces= new Pieces();
		pieces.create_piece(2);
	}
	
	@Test
	public void shouldreturntrueforBloquedroite() {
		pieces.position_piececourante[0]=0;
		pieces.position_piececourante[1]=19;
		pieces.rotation_piececourante=0;
		boolean retour;
		//retour=BlocagePieces.bloquedroite(pieces.position_piececourante,pieces.rotation_piececourante);
		//assertEquals(false,pieces.create_piece(2));
	}

}
