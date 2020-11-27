package game_components;



public abstract class Player {
    protected String name;
    protected int win = 0;
    protected char pawn;
    protected int type;

    public Player(String name){
        this.name = name;
    }

    public abstract int nextMove(Grid grid);

    public void incWin() {
        this.win = this.win+1;
    }

    public String getName() {
        return name;
    }

    public int getWin() {
        return win;
    }

    public char getPawn() {
        return pawn;
    }

    public int getType(){
        return this.type;
    }

    public void setWin(int win) {
        this.win = win;
    }
}