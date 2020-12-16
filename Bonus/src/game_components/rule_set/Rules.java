package game_components.rule_set;

import game_components.rule_set.Rules;
import game_components.Grid;

public abstract class Rules {
    public int PawnsToWin;

    public Rules(int pawns){this.PawnsToWin = pawns;}
    public Rules(){this.PawnsToWin = 4;}

    abstract int linearWin(int x, int y, int stepX, int stepY, char pion, Grid grid);

    abstract public boolean IsWin(int x, int y, char pion, Grid grid);


    public int getPoundsToWin() {
        return PawnsToWin;
    }

    public void setPoundsToWin(int pawnsToWin) {
        PawnsToWin = pawnsToWin;
    }
}
