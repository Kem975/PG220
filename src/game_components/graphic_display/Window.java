package game_components.graphic_display;

import javax.swing.JFrame;

public class Window extends JFrame{

    public Window(){
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setContentPane(new Panel(256,256));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
