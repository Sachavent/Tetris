package DeroulementJeu;

public class Score {
	private static int score;
	
	public static void augmenteScore() {
		// si le score == 10 -> envoie malus
		score++;
	}
	
	public static int getScore() {
		return score;
	}
	public static void setScore(int newscore) {
		score=newscore;
	}
}