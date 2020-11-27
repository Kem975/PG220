package game_components;



public abstract class Rules {
    public int PoundsToWin;

    public Rules(int pounds){this.PoundsToWin = pounds;}

    public abstract int linearWin(int x, int y, int stepX, int stepY, char pion, Grid grid);

    public abstract boolean IsWin(int x, int y, char pion, Grid grid);


    public int getPoundsToWin() {
        return PoundsToWin;
    }

    public void setPoundsToWin(int poundsToWin) {
        PoundsToWin = poundsToWin;
    }
}
