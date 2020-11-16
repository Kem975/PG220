package game_components.players;

import java.util.Random;
import game_components.Player;
import game_components.Grid;
import java.util.Scanner;

public class IARandom extends Player {

    public IARandom(String name,char pawn){
        super(name);
        this.pawn = pawn;
    }

    public int nextmove(Grid grille,Scanner in){
        Random rand = new Random();
        return rand.nextInt(grille.getWidth());
    }


    public void incWin() {
        this.win = this.win+1;
    }
}