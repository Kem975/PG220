package game_components.graphic_display.states;

import game_components.Grid;
import game_components.Player;
import game_components.graphic_display.MouseHandler;
import game_components.rule_set.Rules;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameStateManager {

    private final ArrayList<GameState> states;
    public static final int PLAY = 0;
    public static final int WIN = 1;
    public Grid grid;
    public Player[] players;
    private final int nbRound;
    private int winner;
    Rules[] rules;
    Color[] color_paws;

    public GameStateManager(Grid grid, Player[] players,int nbRound,Rules[] rules){
        states = new ArrayList<>();
        this.winner = -1;
        this.grid = grid;
        this.rules = rules;
        this.nbRound = nbRound;
        this.players = players;
        states.add(new PlayState(this,nbRound));
        if(players.length > 2){
            this.color_paws = new Color[players.length];
            Random rand = new Random();
            for(int i=0;i<players.length;i++){
                float r = rand.nextFloat();
                float g = rand.nextFloat()/2f;
                float b = rand.nextFloat();
                System.out.println(r+" "+g+" "+b);
                color_paws[i] = new Color(r,g,b);

            }
        }
    }

    public void pop(int state){
        states.remove(state);
    }

    public void setWinner(int winner){
        this.winner = winner;
    }

    public void add(int state){
        if(state== PLAY){
            states.add(new PlayState(this ,nbRound));
        }
        if(state == WIN){
            states.add(new WinState(this,nbRound,winner));
        }
    }

    public void addAndPop(int state){
        states.remove(0);
        add(state);
    }

    public void update(){
        for (GameState state : states) {
            state.update();
        }
    }

    public void input(MouseHandler mouse){
        for (GameState state : states) {
            state.input(mouse);
        }
    }

    public void render(Graphics2D graphics){
        for (GameState state : states) {
            state.render(graphics);
        }
    }
}
