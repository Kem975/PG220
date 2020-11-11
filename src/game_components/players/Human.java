package game_components.players;

import java.util.Scanner;
import game_components.Player;
import game_components.Grid;

public class Human extends Player {

    public Human(String name){
        super(name, 0);
    }

    public int Nextmove(Grid grille,Scanner in){
        int colonne = in.nextInt();
        if(colonne>0 && colonne<=grille.getWidth()){
            return colonne-1;
        }
        else{
            System.out.println("Colonne non valide\n");
            return Nextmove(grille,in);
        }
    }

    public String GetNom() {
        return this.nom;
    }

}