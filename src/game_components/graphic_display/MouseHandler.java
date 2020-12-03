package game_components.graphic_display;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;
    private static boolean mouseClicked = false;

    public MouseHandler(Panel panel){
        panel.addMouseListener(this);
    }

    public boolean isClicked() {
        if (mouseClicked){
            this.mouseUnclicked();
            return true;
        }
        return false;
    }

    public int getX(){
        return mouseX;
    }

    public int getY(){
        return mouseY;
    }

    public int getButton(){
        return mouseB;
    }

    public void mouseUnclicked(){
        mouseClicked=false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        mouseClicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}
