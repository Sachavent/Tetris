package DeroulementJeu;

import java.io.IOException;

import GestionFichier.ScoreFile;

// Score h�rite de ScoreFile afin de pouvoir lire / �crire dans le fichier "Scores.txt"
public class Score extends ScoreFile{
	private static int score;
	private static int[] tableauscore;
	
	public static void augmenteScore() {
		// si le score == 10 -> envoie malus
		score++;
	}
	// Fonction qui retourne le score actuel
	public static int getScore() {
		return score;
	}
	
	public static void setScore(int newscore) {
		score=newscore;
	}
	
	public static void setScoreFinPartie() throws IOException {
		tableauscore=lectureFichierScore();
		for (int i=0; i < tableauscore.length; i++) {
			if (score > tableauscore[i]) {
				tableauscore[i]=score;
				ecritureFichierScore(score, i+1);
			}
		}
	}
	public static int[] getTableauScore() {
		return tableauscore;
	}
}
