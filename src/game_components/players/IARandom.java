package game_components;

import java.util.Random

public class IARandom extends Player {

    public IARandom(String name){
        super(name, 1);
    }

    int Nextmove(Grid grille){
        Random rand = new Random();
        return rand.nextInt(grille.getWidth());
    }
}