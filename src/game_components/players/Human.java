package game_components.players;

import java.io.IOException;
import java.util.Scanner;
import game_components.Player;
import game_components.Grid;
import game_components.Log;

public class Human extends Player {

    protected Log log;

    public Human(String name, char pawn, Log log) {
        super(name);
        this.pawn = pawn;
        this.type = 0;
        this.log = log;
    }

    public int nextMove(Grid grille) {
        int colonne;
        while (true) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            try {
                colonne = Integer.parseInt(line);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Must be a number greater than 7.");
                try {
                    this.log.writeErrorColumnName(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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