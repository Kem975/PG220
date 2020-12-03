package game_components.graphic_display;

import game_components.Grid;
import game_components.Player;
import game_components.rule_set.Rules;

public class GraphicDisplay {

    Window window;

    public GraphicDisplay(Grid grid, Player[] players, int nbRound, Rules[] rules){
        this.window = new Window(grid,players,nbRound,rules);
    }
}
