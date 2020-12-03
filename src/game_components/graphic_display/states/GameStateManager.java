package game_components.graphic_display.states;

import game_components.Grid;
import game_components.Player;
import game_components.graphic_display.MouseHandler;
import game_components.rule_set.Rules;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager {

    private ArrayList<GameState> states;
    public static final int PLAY = 0;
    public static final int WIN = 1;
    public Grid grid;
    public Player[] players;
    private int nbRound;
    private int winner;
    private Rules[] rules;

    public GameStateManager(Grid grid, Player[] players,int nbRound,Rules[] rules){
        states = new ArrayList<GameState>();
        this.winner = -1;
        this.rules = rules;
        this.nbRound = nbRound;
        this.players = players;
        states.add(new PlayState(this, grid,players,nbRound,rules));
    }

    public void pop(int state){
        states.remove(state);
    }

    public void setWinner(int winner){
        this.winner = winner;
    }

    public void add(int state){
        if(state== PLAY){
            states.add(new PlayState(this, this.grid,players,nbRound,rules));
        }
        if(state == WIN){
            states.add(new WinState(this,grid,players,nbRound,winner));
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
