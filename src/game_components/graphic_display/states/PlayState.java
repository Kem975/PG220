package game_components.graphic_display.states;

import game_components.Grid;
import game_components.Player;
import game_components.graphic_display.MouseHandler;

import java.awt.*;


public class PlayState extends GameState {

    private static int blockSize = 50;
    private int turn;

    public PlayState(GameStateManager gsm, Grid grid, Player[] players){
        super(gsm,grid,players);
        turn =0;
    }

    public void update(){

    }

    public void input(MouseHandler mouse){
        if(mouse.isClicked()){
            int i = mouse.getX()/blockSize;
            if(grid.turnNoLog(i,this.players[this.turn].getPawn())!=-1){
                this.turn+=1;
                this.turn = (this.turn)%(this.players).length;
            }
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
    }
}
