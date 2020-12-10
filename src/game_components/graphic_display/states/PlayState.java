package game_components.graphic_display.states;


import game_components.graphic_display.MouseHandler;
import game_components.rule_set.Rules;

import java.awt.*;


public class PlayState extends GameState {

    private final int blockSize = 50;
    private int turn;
    private int lastCol;
    private int lastY;
    private boolean win;

    public PlayState(GameStateManager gsm, int nbRound){
        super(gsm,nbRound);
        this.lastCol = -1;
        this.lastY = -1;
        turn =0;
        this.win = false;
    }

    public void update(){
        if(gsm.players[turn].getType()==1){
            this.lastCol = gsm.players[turn].nextMove(gsm.grid);
            this.lastY = gsm.grid.turnNoLog(this.lastCol,gsm.players[this.turn].getPawn());
            if(this.lastY!=-1){
                for (Rules rule : gsm.rules) {
                    if (rule.IsWin(this.lastY, this.lastCol, gsm.players[turn].getPawn(), gsm.grid)) {
                        super.gsm.setWinner(turn);
                        gsm.players[turn].incWin();
                        this.win = true;
                    }
                }
                if(gsm.grid.tie()){
                    super.gsm.setWinner(-1);
                    this.win = true;
                }
                this.lastCol = -1;
                this.turn = (this.turn+1)%(gsm.players).length;
            }
        }
    }

    public void input(MouseHandler mouse){
        if(mouse.isClicked()){
            int i = mouse.getX()/blockSize;
            this.lastY=gsm.grid.turnNoLog(i,gsm.players[this.turn].getPawn());
            if(lastY!=-1){
                this.lastCol = i;
                for (int k = 0; k < gsm.rules.length; k++) {
                    if (gsm.rules[k].IsWin(this.lastY,this.lastCol,gsm.players[turn].getPawn(),gsm.grid)){
                        super.gsm.setWinner(turn);
                        gsm.players[turn].incWin();
                        this.win = true;
                    }
                }
                if(gsm.grid.tie()){
                    super.gsm.setWinner(-1);
                    this.win = true;
                }
                this.turn+=1;
                this.turn = (this.turn)%(gsm.players).length;
            }
            this.lastCol = -1;
        }
    }

    public void render(Graphics2D graphics){
        graphics.setColor(new Color(4, 45, 120));
        graphics.fillRect(0,0,gsm.grid.getWidth()*blockSize,gsm.grid.getLength()*blockSize);
        if(gsm.players.length == 2) {
            for (int i = 0; i < gsm.grid.getWidth(); i++) {
                for (int j = 0; j < gsm.grid.getLength(); j++) {
                    if (gsm.grid.getGrid()[j][i] == 'X') {
                        graphics.setColor(Color.yellow);
                    } else if (gsm.grid.getGrid()[j][i] == 'O') {
                        graphics.setColor(Color.red);
                    } else {
                        graphics.setColor(Color.white);
                    }
                    graphics.fillOval(i * blockSize, j * blockSize, blockSize, blockSize);
                }
            }
        }
        else{
            for(int i = 0; i < gsm.grid.getWidth(); i++) {
                for (int j = 0; j < gsm.grid.getLength(); j++) {
                    if (gsm.grid.getGrid()[j][i] == '.') {
                        graphics.setColor(Color.white);
                    }
                    else{
                        for(int player=0;player<gsm.players.length;player++){
                            if(gsm.grid.getGrid()[j][i] == gsm.players[player].getPawn()){
                                graphics.setColor(gsm.color_paws[player]);
                            }
                        }
                    }
                    graphics.fillOval(i * blockSize, j * blockSize, blockSize, blockSize);
                }
            }

        }
        if(win){
            super.gsm.addAndPop(GameStateManager.WIN);
        }
    }
}
