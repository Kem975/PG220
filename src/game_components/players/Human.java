package game_components.players;

import java.io.IOException;
import java.util.Scanner;
import game_components.Player;
import game_components.Grid;
import game_components.Log;
import game_components.Game;

public class Human extends Player {

    Log log;
    Scanner sc;

    public Human(String name, char pawn, Log log) {
        super(name,pawn,0);
        this.log = log;
        this.sc = new Scanner(System.in,"UTF-8");

    }

    public int nextMove(Grid grille) {
        int colonne;
        while (true) {
            String line = this.sc.nextLine();
            Game.isSortir(line);
            try {
                colonne = Integer.parseInt(line);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Must be a number.");
                try {
                    this.log.writeErrorColumnName(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if(colonne>0 && colonne<=grille.getWidth()){
            return colonne-1;
        }
        else{
            System.out.println("Incorrect move");
            return nextMove(grille);
        }
    }

    public void freeScanner(){
        this.sc.close();
    }

}