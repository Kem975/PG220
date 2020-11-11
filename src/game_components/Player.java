package game_components;

import java.util.Scanner;


public abstract class Player {
    protected String nom;
    private int type;

    public Player(String nom, int type){
        this.nom = nom;
        this.type = type;
    }

    public abstract int Nextmove(Grid grille,Scanner in);

    public abstract String GetNom();

}