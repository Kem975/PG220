package game_components.graphic_display.states;

import game_components.Grid;
import game_components.Player;
import game_components.graphic_display.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState {

    protected final GameStateManager gsm;
    protected final Grid grid;
    protected final Player[] players;
    protected  final int nbRound;

    public GameState(GameStateManager gsm, Grid grid, Player[] players,int nbRound){
        this.gsm = gsm;
        this.grid = grid;
        this.players = players;
        this.nbRound = nbRound;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse);
    public abstract void render(Graphics2D graphics);
}
