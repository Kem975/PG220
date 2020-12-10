package game_components.graphic_display.states;

import game_components.graphic_display.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState {

    protected final GameStateManager gsm;
    protected  final int nbRound;

    public GameState(GameStateManager gsm,int nbRound){
        this.gsm = gsm;
        this.nbRound = nbRound;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse);
    public abstract void render(Graphics2D graphics);
}
