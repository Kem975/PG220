package game_components.graphic_display;

import game_components.Grid;
import game_components.Player;

public class GraphicDisplay {

    Window window;

    public GraphicDisplay(Grid grid, Player[] players){
        this.window = new Window(grid,players);
    }
}
