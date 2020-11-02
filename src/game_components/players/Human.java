package game_components.players;

import java.util.Scanner;
import game_components.Player;
import game_components.Grid;

public class Human extends Player {

    public Human(String name){
        super(name, 0);
    }

    public int Nextmove(Grid grille){
        Scanner sc = new Scanner(System.in);
        int colonne = sc.nextInt();
        if(colonne>0 && colonne<=grille.getWidth()){
            return colonne;
        }
        else{
            System.out.println("Colonne non valide\n");
            return Nextmove(grille);
        }
    }

}