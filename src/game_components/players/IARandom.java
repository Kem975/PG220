package game_components.players;

import java.util.Random;
import game_components.Player;
import game_components.Grid;
import java.util.Scanner;

public class IARandom extends Player {

    public IARandom(String name){
        super(name);
    }

    public int nextmove(Grid grille,Scanner in){
        Random rand = new Random();
        return rand.nextInt(grille.getWidth());
    }


    public int getWin() {
        return this.win;
    }

    public void incWin() {
        this.win = this.win+1;
    }
}