package game_components;

import java.util.Scanner;


public abstract class Player {
    protected String nom;
    protected int win = 0;

    public Player(String nom){
        this.nom = nom;
    }

    public abstract int Nextmove(Grid grille,Scanner in);

    public abstract String GetNom();

    public abstract int GetWin();

    public abstract void IncWin();

}