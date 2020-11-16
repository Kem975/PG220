package game_components;

import java.util.Scanner;


public abstract class Player {
    protected String name;
    protected int win = 0;

    public Player(String name){
        this.name = name;
    }

    public abstract int nextmove(Grid grid,Scanner in);

    public abstract void incWin();

    public String getName() {
        return name;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}