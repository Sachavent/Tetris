package Launcher;


import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import DeroulementJeu.Deroulement;
import InterfaceGraphique.Fenetre;
import InterfaceReseau.Joueur1;
import InterfaceReseau.Joueur2;
import junit.framework.Assert;

public class Launcher {
	private static boolean flag=true;
	
	public static void main (String[] args)throws IOException, InterruptedException {
		
		System.out.println("numero du jouueur?");
		Scanner sc = new Scanner(System.in);
		String queljoueur= new String();
		queljoueur=sc.nextLine();
		

				
		if (queljoueur.equals("1")) {
			System.out.println("tu es le joueur: "+queljoueur);
			
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
			
////////////////////CEST ICI QUON LANCE LE TETRIS DU JOUEUR 1 ///////////
			
			System.out.println("Lancement du Tetris");
			
			// Lance le jeu
			Deroulement deroulement = new Deroulement();
			
			// Initialisation du plateau de jeu
			deroulement.initialise();
			
			//Tant qu'on a pas perdu, le jeu continu
			while (flag==true) {
			deroulement.run();
			}
			
		} else {
			// On s'assure qu'il y a d�j� un joueur 1 (sinon pas de serveur auquel se connecter)

				System.out.println("tu es le joueur: "+queljoueur);
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
////////////////////CEST ICI QUON LANCE LE TETRIS DU JOUEUR 2 ///////////
				 System.out.println("Lancement du Tetris");
					
					// Lance le jeu
					Deroulement deroulement = new Deroulement();
					
					// Initialisation du plateau de jeu
					deroulement.initialise();
					
					//Tant qu'on a pas perdu, le jeu continu
					while (flag==true) {
					deroulement.run();
					}
			
		}
		
		
	}
}
