package games;
import java.util.*;

public class Sokoban {
   protected char [][] grille = new char [4][4];  // Deplacable inclu le Joueur et la Caisse
   protected int nbCoups = 0; // Nombre de déplacement éffectué durant le niveau
   protected char caisse = 'C';
   protected char joueur = 'J';
   protected Player joueur1;
   protected int k; // Position du joueur
   protected int n = 4;
   protected int m = 4;

// Constructeur du Jeu Sokoban
	public Sokoban(/*Player getJoueur1*/){
   }

// Temporaire Affichage grille
	public String affiche(){
		System.out.print("  -------");
		for(int t = 0; t < this.m - 1; t++){
			System.out.print(" -------");
		}
		System.out.println(" ");
		for(int i = 0; i < this.m; i++){
			System.out.print(" | ");
			for(int j = 0; j < this.n; j++){
				if(grille[i][j] == 0){
					System.out.print("      | ");
				}
				else{
					System.out.print("  " + grille[i][j] + "   | ");
				}
			}
			System.out.println(" ");
			System.out.print("  -------");
			for(int t = 0; t < this.m - 1; t++){
				System.out.print(" -------");
			}
			System.out.println(" ");
		}
		return " ";
	}


// Initialise les objets sur la grille
   public void init(){
      k = 0;
      grille[(int)(k / this.m)][k % this.n] = joueur;
      grille[1][1] = caisse;
      grille[3][3] = 'X';
   }

// Verfie si toute les caisses ont atteints les objectifs
   public boolean getWinner(){
      if(grille[3][3] == caisse){
         return true;
      }
      return false;
   }

// Incrémente de 1 à chaque deplacements
   public int getScore(){  // Est appelé à chaque jouerCoup
      return nbCoups++;
   }

// Deplace le joueur de une case
   public void jouerCoup(int c){
      this.testCaisse(c);
      this.suppr();
      grille[(int)(c / this.m)][c % this.n] = joueur;
      this.getScore();
      k = c;
   }

   public void suppr(){
		grille[(int)(k / this.m)][k % this.n] = 0;
	}

// Test si la case correspond à une Caisse
   public void testCaisse(int c){
      if(grille[(int)(c / this.m)][c % this.n] == caisse){
         this.moveCaisse(c);
      }
   }

// Deplace | Supprime Caisse
   public void moveCaisse(int c){
      if(c - k == 1){      // Decalage a droite
         grille[(int)((c + 1) / this.m)][(c + 1) % this.n] = caisse;
      }
      if(c - k == -1){     // Decalage a gauche
         grille[(int)((c - 1) / this.m)][(c - 1) % this.n] = caisse;
      }
      if(c - k == this.m){ // Decalage en bas
         grille[(int)((c + this.m) / this.m)][(c + this.n) % this.n] = caisse;
      }
      if(c - k == -this.m){ // Decalage en haut
         grille[(int)((c - this.m) / this.m)][(c - this.n) % this.n] = caisse;
      }
   }



   public boolean validCase(int c){
      List<Integer> listeTest = coupPossible();
      for(int i = 0; i < listeTest.size(); i++){
         int f = listeTest.get(i);
         if(c == f){
            return true;
         }
      }
      return false;
   }

// Liste les deplacements possibles
   public List<Integer> coupPossible(){
      List<Integer> listCase = new ArrayList<> ();
      try{
			if(grille[(int)((k + 1) / this.m)][(k + 1) % this.n] == 0 | grille[(int)((k + 1) / this.m)][(k + 1) % this.n] == caisse){
			  	listCase.add(k + 1);
		  	}
		}
		catch(ArrayIndexOutOfBoundsException exception){
		}
		try{
			if(grille[(int)((k - 1) / this.m)][(k - 1) % this.n] == 0 | grille[(int)((k - 1) / this.m)][(k - 1) % this.n] == caisse){
				listCase.add(k - 1);
		  	}
		}
		catch(ArrayIndexOutOfBoundsException exception){
		}
		try{
			if(grille[(int)((k + this.m) / this.m)][(k + this.n) % this.n] == 0 | grille[(int)((k + this.m) / this.m)][(k + this.n) % this.n] == caisse){
				listCase.add(k + this.n);
			}
		}
		catch(ArrayIndexOutOfBoundsException exception){
		}
		try{
			if(grille[(int)((k - this.m) / this.m)][(k - this.n) % this.n] == 0 | grille[(int)((k - this.m) / this.m)][(k - this.n) % this.n] == caisse){
			  	listCase.add(k - this.n);
		  	}
		}
		catch(ArrayIndexOutOfBoundsException exception){
		}
      return listCase;
   }



// Test si la case correspond à un Mur
//   public boolean testMur(int caseTester);

}
