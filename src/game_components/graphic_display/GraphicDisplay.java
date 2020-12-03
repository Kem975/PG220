package game_components.graphic_display;

import game_components.Grid;

public class GraphicDisplay {

    Window window;

    public GraphicDisplay(Grid grid){
        this.window = new Window(grid);
    }
}
