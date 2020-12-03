package game_components.graphic_display;

import javax.swing.JFrame;

public class Window extends JFrame{

    public Window(){
        setTitle("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setContentPane(new Panel(512,512));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
