package inputs;

import entities.Manaball;
import main.GamePanel;
import entities.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE -> gamePanel.getGame().getController().addManaball(new Manaball(gamePanel.getGame().getPlayer().getxValue(), gamePanel.getGame().getPlayer().getyValue(), 64, 64));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

}
