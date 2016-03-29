package GestionFichier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScoreFile {
	public static void main(String[] args) {	
		final String chemin = "src/testFileWriter.txt";
	    File file = new File(chemin);
	    FileWriter fw;
	    FileReader fr;
			
	    try {

			
	        //Lecture des scores
	        fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr); 
	        // On cr�e un scanner qui va r�cup�rer les int
	        Scanner scanner = new Scanner(file);
	        int scorerecupere;
	        String entre;
	        int nombreligne=0;
	        int[] valeursrecuperees= new int [5];
	        //Lecture des donn�es
	        // On lit les lignes une part une tant qu'il y en a encore
	        while((entre = br.readLine()) != null) {
	        	// NextInt permet de recup�rer le prochain integer
		        scorerecupere=scanner.nextInt();
	        	System.out.println("score: "+ scorerecupere);
		        valeursrecuperees[nombreligne]=scorerecupere;
		        System.out.println("tableau :"+valeursrecuperees[nombreligne]);
		        nombreligne++;
	        	
	        
	        }
	        //Affichage
	        System.out.println("Affichage du tableau final");
	        for (int compteur = 0; compteur < 5; compteur++) {
	        	System.out.print(" " +valeursrecuperees[compteur]);
	        }
	        br.close();
	        fr.close();
	        
	        
	        
		   // Ecriture dans le fichier
	 	   fw = new FileWriter(file);
	 	   String str="";
	        for (int compteur = 0; compteur < 5; compteur++) {
		 	      //On �crit la cha�ne
		 	      fw.write(new Integer(valeursrecuperees[compteur]).toString());
		 	     fw.write("\n");
	        }

	 	      //On ferme le flux
	 	      fw.close();
	        
	        
	        
	        

	    } 
	    catch (NoSuchElementException e)
        {    e.printStackTrace();
        }
	    catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}