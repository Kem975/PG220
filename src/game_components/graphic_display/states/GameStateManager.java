package game_components.graphic_display.states;

import game_components.graphic_display.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;

    public GameStateManager(){
        states = new ArrayList<GameState>();

        states.add(new PlayState(this));
    }

    public void update(){
        for(int i=0;i<states.size();i++){
            states.get(i).update();
        }
    }

    public void input(MouseHandler mouse){
        for(int i=0;i<states.size();i++){
            states.get(i).input(mouse);
        }
    }

    public void render(Graphics2D graphics){
        for(int i=0;i<states.size();i++){
            states.get(i).render(graphics);
        }
    }
}
