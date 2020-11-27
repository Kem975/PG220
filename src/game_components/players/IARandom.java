package game_components.players;

import java.util.Random;
import game_components.Player;
import game_components.Grid;

public class IARandom extends Player {

    public IARandom(String name,char pawn){
        super(name);
        this.pawn = pawn;
        this.type = 1;
    }

    public int nextMove(Grid grille){
        Random rand = new Random();
        return rand.nextInt(grille.getWidth());
    }


    
}