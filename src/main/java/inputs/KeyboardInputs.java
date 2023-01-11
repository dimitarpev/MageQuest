package inputs;

import entities.Manaball;
import main.GamePanel;
import entities.Entity;
import entities.Player;
import utilz.Constants.Directions.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

import static utilz.Constants.Directions.*;


public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    private Player player;
    boolean canShoot = false;
    int tick = 0;
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
            case KeyEvent.VK_SPACE -> {
                if (gamePanel.getGame().getPlayer().CANSHOOT) {
                    gamePanel.getGame().getController().addManaball(new Manaball(gamePanel.getGame().getPlayer().getxValue() + 30, gamePanel.getGame().getPlayer().getyValue() - 30, 128, 128));
                    gamePanel.getGame().getPlayer().setCANSHOOT(canShoot);
                }
            }
        }
//        if (e.getKeyCode() == KeyEvent.VK_SPACE && canShoot){
//            gamePanel.getGame().getController().addManaball(new Manaball(gamePanel.getGame().getPlayer().getxValue() + 30, gamePanel.getGame().getPlayer().getyValue() - 30, 128, 128));
//
//            canShoot();
//
//        } else if (e.getKeyCode() == KeyEvent.VK_W) {
//            gamePanel.getGame().getPlayer().setUp(true);
//        } else if (e.getKeyCode() == KeyEvent.VK_S) {
//            gamePanel.getGame().getPlayer().setDown(true);
//        }
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

//    public void canShoot() {
//        tick = 0;
//        canShoot = false;
//        while (tick <= 1000000) {
//            tick++;
//        }
//        canShoot = true;
//    }

}
