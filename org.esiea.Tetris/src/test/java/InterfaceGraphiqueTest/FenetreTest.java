package InterfaceGraphiqueTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import InterfaceGraphique.Fenetre;

public class FenetreTest {

	// Test pour v�rifier que la fenetre existe
	@Test
	public void shouldReturnNotNull() {
		Fenetre fenetre= new Fenetre();
		Assert.assertNotNull(fenetre);
	}

}