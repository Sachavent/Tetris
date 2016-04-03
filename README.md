Réalisé par Sylvain VENTRIBOUT & Vincent ETIENNE

Tetris réalisé en Java, comprenant un mode multijoueur sur le réseau local (via l’intermédiaire de Socket).

L’architecture du projet est disponible à l’adresse suivante :
https://drive.google.com/folderview?id=0Bx19VItk8DBNak1DVkVUQlBwVk0&usp=sharing

Nous avons essayé de respecter au maximum le principe SOLID ainsi que le modèle C4 pour notre architecture.

Nous avons utilisé les Design Pattern suivants :

-	Listener : Afin d’écouter les événements de l’utilisateur. Dans notre Tetris nous avons notamment implémenté l’interface « KeyListener » dans la classe « GestionClavier » afin de gérer le déplacement des pièces ainsi que leur rotation. 
Concrètement, nous nous sommes surtout servit de la fonction «  KeyPressed », qui s’active quand l’utilisateur appuie sur une touche du clavier.
-	Mutex (Mutual Exclusion) : Nous l’avons utilisé pour résoudre des problèmes de concurrences d’accès suite au multithreading.
Dans notre code, nous l’avons utilisé pour synchronisé la variable « create_new_piece » dans la classe Déroulement. En effet, cette variable est partagé entre l’instance principale du jeu et le thread qui gère la descente des pièces… Avant qu’on mette en place ce mutex, parfois certaines pièces ne se crée pas et le jeu restait bloqué.

Principe utilisés :
-	Nous avons essayé de ne gardé qu’une seule instance de chaque objet (exemple : qu’un seul Board ou qu’une seule piece courante) qu’on « partage » entres les différentes classes via des setters ou des getters
-	Nous avons crée toute les pièces à partir d’un même fichier. Notre système est extensible. En effet, il est possible de pouvoir créer autant de pièces qu’on le souhaite en utilisant notre classe.
Remarque : 
	Pour faire fonctionner le jeu en multijoueur il faut remplacer l’adresse IP de la classe « Joueur2 » à cette ligne : « socket = new Socket (« VOTRE @ IP », 2015) ; » . Pour connaître votre adresse IP : ipconfig (sous Windows)


Pour exécuter notre jeu : 
	-Vous pouvez utilisé l’IDE Eclipse. Puis, importer le projet et enfin faire un « update project », (ça correspond au maven install)
	-Executer le .jar transmis par mail
