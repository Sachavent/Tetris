package DeroulementJeuTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DeroulementJeu.Score;

public class ScoreTest {

	@Before
	public void initialisation() {
		Score score= new Score();
	}
	
	
	@Test
	public void shouldReturnScoreegal1() {
		// on met le score à 0 puis on l'augmente de 1
		Score.setScore(0);
		Score.augmenteScore();
		assertEquals(Score.getScore(),1);
	}

}
