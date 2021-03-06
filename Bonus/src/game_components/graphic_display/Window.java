package game_components.graphic_display;

import javax.swing.JFrame;
import game_components.Grid;
import game_components.Player;
import game_components.rule_set.Rules;


@SuppressWarnings("serial")
public class Window extends JFrame{

    public Window(Grid grid, Player[] players,int nbRound,Rules[] rules){
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(grid.getWidth()*50,grid.getLength()*50+35);
        setContentPane(new Panel(grid,players,nbRound,rules));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
