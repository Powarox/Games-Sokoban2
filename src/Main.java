package games;
import java.util.*;

public class Main {
	public static void main (String [] args) {

		Scanner scanner = new Scanner(System.in);
//		System.out.println("Saisissez un nom de joueur : ");
//		String joueur1 = scanner.nextLine();

      Sokoban test = new Sokoban(/*new Player(joueur1)*/);

		test.init();
      test.affiche();

		while(test.getWinner() == false){
			// System.out.println(test.joueur1 + " Joue");

			System.out.println("Les cases possible sont :" + test.coupPossible());

			System.out.println("Saisissez la Case : ");
			int c = scanner.nextInt();

			while(test.validCase(c) == false){
				System.out.println("Veuillez selection une Case valide: ");
				c = scanner.nextInt();
			}

			test.jouerCoup(c);	// Ajoute un nouveau Pion
			test.affiche();		// Affiche la grille
			System.out.println("Nombre coup joue : " + test.getScore());
		}
   }
}
