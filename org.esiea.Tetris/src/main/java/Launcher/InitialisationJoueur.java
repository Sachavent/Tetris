package Launcher;

import java.io.IOException;
import java.net.UnknownHostException;

import InterfaceGraphique.Fenetre;
import InterfaceReseau.Joueur1;
import InterfaceReseau.Joueur2;

public class InitialisationJoueur {

	public static void initialisationJoueur (int numerojoueur) {

		switch (numerojoueur) {
		case 0:
			//Pas besoin d'initialiser une interface reseau donc on return tout simplement
			return;
		case 1:
			lancementJoueur1();
			return;
		case 2:
			lancementJoueur2();
			return;
		default: return;
		}
	}
	
	public static void lancementJoueur1() {
		
		System.out.println("tu es le joueur: "+Fenetre.getCurrentPlayer());
		
		// On cr�e le joueur 1 qui correspond au serveur
		final Joueur1 j1= new Joueur1();
		// Runnable qui permet de lancer le serveur (qui est le joueur 1)
		Runnable joueur1 = new Runnable () {
			public void run() {
				try {
					j1.launch();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		// On lance le thread du JOUEUR 1
		Thread t_joueur1=new Thread(joueur1,"Joueur1");
		t_joueur1.start();
		
	}
	
	public static void lancementJoueur2() {
		
		System.out.println("tu es le joueur: "+Fenetre.getCurrentPlayer());
		final Joueur2 j2= new Joueur2();
		Runnable joueur2= new Runnable () {
			public void run() {

					try {
						j2.launch();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		};
		
		// On lance le thread du JOUEUR 2
		 
		Thread t_joueur2 = new Thread (joueur2);
		 t_joueur2.start();
		
	}
	
	
	
}
