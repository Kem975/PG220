package game_components.graphic_display.states;

import game_components.Grid;
import game_components.graphic_display.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState {

    private final GameStateManager gsm;
    protected final Grid grid;

    public GameState(GameStateManager gsm, Grid grid){
        this.gsm = gsm;
        this.grid = grid;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse);
    public abstract void render(Graphics2D graphics);
}
