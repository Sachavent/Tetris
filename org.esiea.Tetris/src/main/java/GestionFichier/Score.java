package GestionFichier;

public class Score {
	private static int score;
	
	public static void augmenteScore() {
		// si le score == 10 -> envoie malus
		score++;
	}
	
	public static int getScore() {
		return score;
	}
}
