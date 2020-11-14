package game_components.players;

import java.util.Random;
import game_components.Player;
import game_components.Grid;
import java.util.Scanner;

public class IARandom extends Player {

    public IARandom(String name){
        super(name);
    }

    public int Nextmove(Grid grille,Scanner in){
        Random rand = new Random();
        return rand.nextInt(grille.getWidth());
    }

    public String GetNom() {
        return this.nom;
    }
}