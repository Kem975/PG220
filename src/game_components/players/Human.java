package game_components.players;

import java.util.Scanner;
import game_components.Player;
import game_components.Grid;

public class Human extends Player {

    public Human(String name,char pawn){
        super(name);
        this.pawn = pawn;
        this.type = 0;
    }

    public int nextMove(Grid grille){
        int colonne;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                colonne = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 7.");
            }
            sc.close();
        }

        if(colonne>0 && colonne<=grille.getWidth()){
            return colonne-1;
        }
        else{
            System.out.println("Incorrect move");
            return nextMove(grille);
        }
    }


}