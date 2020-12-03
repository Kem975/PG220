package game_components.graphic_display.states;

import game_components.Grid;
import game_components.GridTailleException;
import game_components.Player;
import game_components.graphic_display.MouseHandler;

import java.awt.*;

public class WinState extends GameState {

    private int winner;
    private static int blockSize = 50;

    public WinState(GameStateManager gsm, Grid grid, Player[] players,int nbRound,int winner){
        super(gsm,grid,players,nbRound);
        this.winner = winner;
    }

    public void update(){

    }

    public void input(MouseHandler mouse){
        if(mouse.isClicked()){
            gsm.players = players;
            try {
                gsm.grid = new Grid(grid.getLength(), grid.getWidth());
            } catch (GridTailleException e) {
                e.printStackTrace();
            }
            gsm.addAndPop(GameStateManager.PLAY);
        }
    }

    public void render(Graphics2D graphics){
        assert grid != null;

        if(winner<0){
            graphics.setColor(Color.black);
            graphics.drawString("Tie !",100,100);
        }
        else if(players[winner].getWin() < nbRound) {
            graphics.setColor(Color.black);
            graphics.drawString("Player " + winner + " " + players[winner].getName() + " win" + players[winner].getWin() + " out of " + nbRound, 100, 100);
        }
        else if(players[winner].getWin() == nbRound){
            graphics.setColor(Color.black);
            graphics.drawString("Player "+players[winner].getName()+" win !",100,100);
        }
    }
}
