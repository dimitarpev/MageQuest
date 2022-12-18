package inputs;

import entities.Manaball;
import main.GamePanel;
import entities.Entity;
import entities.Player;
import utilz.Constants.Directions.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Directions.*;


public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    private Player player;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.getGame().getPlayer().setUp(true);
            case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(true);
            case KeyEvent.VK_SPACE -> gamePanel.getGame().getController().addManaball(new Manaball(gamePanel.getGame().getPlayer().getxValue() + 30, gamePanel.getGame().getPlayer().getyValue() - 30, 128, 128));

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.getGame().getPlayer().setUp(false);
            case KeyEvent.VK_S:
                gamePanel.getGame().getPlayer().setDown(false);
                break;
        }


    }

}
