package InterfaceReseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Joueur {
	// Fonction qui permet d'envoyer un message
	public static void sendmessage(String message,Socket s, PrintWriter print) {
        print.println(message);
        print.flush();
	}
	
	public static String recievemessage(BufferedReader recieve) throws IOException {
		String message_distant=null;
		try {
        message_distant = recieve.readLine();
		} catch (SocketException e) {
			System.out.println("la connexion est d�j� ferm�");
		}
		// Affiche le message re�ut
        System.out.println(message_distant);
        return message_distant;
        
	}
}
