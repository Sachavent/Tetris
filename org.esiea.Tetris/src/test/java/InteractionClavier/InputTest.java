package InteractionClavier;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


import org.junit.Before;
import org.junit.Test;

import GestionFichier.Pieces;
import junit.framework.Assert;

// MODIFIER CE TEST!!

public class InputTest {
	GestionClavier input;
	Robot robot;
	@Before
	public void initialisation() throws AWTException {
	input =new GestionClavier();
	robot= new Robot();
	}
	
	@Test
	public void shouldReturnInputNotNull(){

		assertEquals(1,2);
		
		
	}

}
