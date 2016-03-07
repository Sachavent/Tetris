package Launcher;


import java.util.Scanner;

import InterfaceGraphique.Fenetre;
import junit.framework.Assert;

public class Launcher {
	
	public static void main (String[] args) {
		System.out.println("Lancement du Tetris");

		Fenetre fenetre= new Fenetre();
		fenetre.creationfenetre();
		
		
	}
}
