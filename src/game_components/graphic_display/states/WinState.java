package game_components.graphic_display.states;

import game_components.Grid;
import game_components.GridTailleException;
import game_components.graphic_display.MouseHandler;

import java.awt.*;

public class WinState extends GameState {

    private final int winner;
    private boolean end = false;

    public WinState(GameStateManager gsm,int nbRound,int winner){
        super(gsm,nbRound);
        this.winner = winner;
        if(gsm.players[winner].getWin() == nbRound){
            end = true;
        }
    }

    public void update(){

    }

    public void input(MouseHandler mouse){
        if(mouse.isClicked()){
            if(end){
                gsm.pop(0);
                return;
            }
            try {
                gsm.grid = new Grid(gsm.grid.getLength(), gsm.grid.getWidth());
            } catch (GridTailleException e) {
                e.printStackTrace();
            }
            gsm.addAndPop(GameStateManager.PLAY);
        }
    }

    public void render(Graphics2D graphics){
        assert gsm.grid != null;

        if(winner<0){
            graphics.setColor(Color.black);
            graphics.drawString("Tie !",100,100);
        }
        else if(gsm.players[winner].getWin() < nbRound) {
            graphics.setColor(Color.black);
            graphics.drawString("Player " + winner + " " + gsm.players[winner].getName() + " win" + gsm.players[winner].getWin() + " out of " + nbRound, 100, 100);
        }
        else if(gsm.players[winner].getWin() == nbRound){
            graphics.setColor(Color.black);
            graphics.drawString("Player "+gsm.players[winner].getName()+" win !",100,100);
        }
    }
}
