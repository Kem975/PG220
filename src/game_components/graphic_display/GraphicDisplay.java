package game_components.graphic_display;

import game_components.Grid;

public class GraphicDisplay {

    Grid grid;
    Window window;

    public GraphicDisplay(Grid grid){
        this.grid = grid;
        this.window = new Window();
    }
}
