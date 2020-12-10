package game_components;



public abstract class Player {
    String name;
    int win = 0;
    char pawn;
    int type;

    public Player(String name,char pawn,int type){
        this.name = name;
        this.pawn = pawn;
        this.type = type;
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

    void setWin(int win) {
        this.win = win;
    }
}