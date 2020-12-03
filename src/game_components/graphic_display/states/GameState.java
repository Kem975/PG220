package game_components.graphic_display.states;

import game_components.graphic_display.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState {

    private final GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse);
    public abstract void render(Graphics2D graphics);
}
