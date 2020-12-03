package game_components.graphic_display.states;

import game_components.Grid;
import game_components.Player;
import game_components.graphic_display.MouseHandler;
import game_components.rule_set.Rules;

import java.awt.*;


public class PlayState extends GameState {

    private static int blockSize = 50;
    private int turn;
    private final Rules rules[];
    private int lastCol;
    private int lastY;
    private boolean win;

    public PlayState(GameStateManager gsm, Grid grid, Player[] players, int nbRound, Rules[] rules){
        super(gsm,grid,players,nbRound);
        this.rules = rules;
        this.lastCol = -1;
        this.lastY = -1;
        turn =0;
        this.win = false;
    }

    public void update(){
        if(players[turn].getType()==1){
            this.lastCol = players[turn].nextMove(grid);
            this.lastY = grid.turnNoLog(this.lastCol,this.players[this.turn].getPawn());
            if(this.lastY!=-1){
                gsm.grid = this.grid;
                for (int k = 0; k < rules.length; k++) {
                    if (rules[k].IsWin(this.lastY,this.lastCol,players[turn].getPawn(),grid)){
                        super.gsm.setWinner(turn);
                        players[turn].incWin();
                        gsm.players = this.players;
                        this.win = true;
                    }
                }
                if(grid.tie()){
                    super.gsm.setWinner(-1);
                    this.win = true;
                }
                this.lastCol = -1;
                this.turn = (this.turn+1)%(this.players).length;
            }
        }
    }

    public void input(MouseHandler mouse){
        if(mouse.isClicked()){
            int i = mouse.getX()/blockSize;
            this.lastY=grid.turnNoLog(i,this.players[this.turn].getPawn());
            if(lastY!=1){
                this.lastCol = i;
                gsm.grid = this.grid;
                for (int k = 0; k < rules.length; k++) {
                    if (rules[k].IsWin(this.lastY,this.lastCol,players[turn].getPawn(),grid)){
                        super.gsm.setWinner(turn);
                        players[turn].incWin();
                        gsm.players = this.players;
                        this.win = true;
                    }
                }
                if(grid.tie()){
                    super.gsm.setWinner(-1);
                    this.win = true;
                }
                this.turn+=1;
                this.turn = (this.turn)%(this.players).length;
            }
            this.lastCol = -1;
        }
    }

    public void render(Graphics2D graphics){
        graphics.setColor(new Color(4, 45, 120));
        graphics.fillRect(0,0,this.grid.getWidth()*blockSize,this.grid.getLength()*blockSize);
        for(int i = 0; i<grid.getWidth();i++){
            for(int j=0;j<grid.getLength();j++){
                if(Character.compare(grid.getGrid()[j][i],'X')==0){
                    graphics.setColor(Color.yellow);
                }
                else if(Character.compare(grid.getGrid()[j][i],'O')==0){
                    graphics.setColor(Color.red);
                }
                else{
                    graphics.setColor(Color.white);
                }
                graphics.fillOval(i*blockSize,j*blockSize,blockSize,blockSize);
            }
        }
        if(win){
            super.gsm.addAndPop(GameStateManager.WIN);
        }
    }
}
