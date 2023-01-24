package gamestates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Statemethods {
    //INTERFACE FOR ALL MAIN METHODS
    public void update();
    public void render(Graphics g);
    public void keyPressed(KeyEvent e);
    public void keyReleased(KeyEvent e);
    public void mouseClicked(MouseEvent e);
    public void mousePressed(MouseEvent e);
    public void mouseReleased(MouseEvent e);
    public void mouseMoved(MouseEvent e);

}
