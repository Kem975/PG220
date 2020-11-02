package game_components;

import java.util.Random

public class IARandom extends Player {

    public IARandom(String name){
        super(name, 1);
    }

    Nextmove(Grid grille){
        Random rand = new Random();
        int colonne = rand.nextInt(grille.getWidth());
    }
}