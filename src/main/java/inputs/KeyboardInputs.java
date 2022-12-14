package inputs;

import main.GamePanel;
import entities.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public boolean upP, downP, leftP, rightP;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code ==KeyEvent.VK_W){upP=true;}
        if (code ==KeyEvent.VK_S){downP=true;}
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if (code ==KeyEvent.VK_W){upP=false;}
        if (code ==KeyEvent.VK_S){downP=false;}
    }

}
