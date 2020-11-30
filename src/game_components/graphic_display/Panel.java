package game_components.graphic_display;

import javax.swing.JPanel;
import java.awt.*;

public class Panel extends JPanel{

    private static int width;
    private static int height;

    public Panel(int width, int height){
        setPreferredSize(new Dimension(width,height));
        setFocusable(true);
        requestFocus();
    }
}
