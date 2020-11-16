package game_components.players;

import java.util.Scanner;
import game_components.Player;
import game_components.Grid;

public class Human extends Player {

    public Human(String name){
        super(name);
    }

    public int nextmove(Grid grille,Scanner in){
        int colonne;
        while (true) {
            try {
                colonne = Integer.parseInt(in.nextLine());
                break;
            }catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 7.");
            }
        }
        if(colonne>0 && colonne<=grille.getWidth()){
            return colonne-1;
        }
        else{
            System.out.println("Colonne non valide\n");
            return nextmove(grille,in);
        }
    }

    public void incWin() {
        this.win = this.win+1;
    }
}