package game_components.graphic_display.states;

import game_components.Grid;
import game_components.graphic_display.MouseHandler;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;
    public static final int PLAY = 0;
    public static final int WIN = 1;
    private Grid grid;

    public GameStateManager(Grid grid){
        states = new ArrayList<GameState>();

        states.add(new PlayState(this, grid));
    }

    public void pop(int state){
        states.remove(state);
    }

    public void add(int state){
        if(state== PLAY){
            states.add(new PlayState(this, this.grid));
        }
        if(state == WIN){
            states.add(new WinState(this,grid));
        }
    }

    public void addAndPop(int state){
        states.remove(0);
        add(state);
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
