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
	
	// Test pour v�rifier que la classe exsiste
	@Test
	public void shouldReturnNotNull() {
		Assert.assertNotNull(pieces);
	}


}
