package game_components;



public abstract class Rules {
    public int PawnsToWin;

    public Rules(int pawns){this.PawnsToWin = pawns;}
    public Rules(){this.PawnsToWin = 4;}

    public abstract int linearWin(int x, int y, int stepX, int stepY, char pion, Grid grid);

    public abstract boolean IsWin(int x, int y, char pion, Grid grid);


    public int getPoundsToWin() {
        return PawnsToWin;
    }

    public void setPoundsToWin(int pawnsToWin) {
        PawnsToWin = pawnsToWin;
    }
}
