package game_components.graphic_display;

import javax.swing.JFrame;
import game_components.Grid;

public class Window extends JFrame{

    public Window(Grid grid){
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(grid.getWidth()*50,grid.getLength()*50);
        //pack();
        setContentPane(new Panel(grid));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
