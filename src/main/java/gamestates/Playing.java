package gamestates;

import entities.*;
import main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Playing extends State implements Statemethods{

    private Player player;
    private Manaball manaball;
    private Score score;
    private Controller controller;
    boolean canShoot = false;
    private Background background;

    public Playing(Game game) {
        super(game);
        initClasses();
    }
    private void initClasses() {
        background = new Background(0, 0, 696, 1920);
        player = new Player(150, 200, (int)(64 * Game.SCALE), (int)(48 * Game.SCALE) );
        controller = new Controller(player);
        score = new Score();
    }

    @Override
    public void update() {
        player.update();
        controller.update();

    }

    @Override
    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        controller.render(g);
        score.render(g);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(true);
            case KeyEvent.VK_S -> player.setDown(true);
            case KeyEvent.VK_SPACE -> {
                if (player.CANSHOOT) {
                    controller.addManaball(new Manaball(player.getxValue() + 30, player.getyValue() - 30, 128, 128));
                    player.setCANSHOOT(canShoot);
                }
            }
            case KeyEvent.VK_ESCAPE -> Gamestate.state = Gamestate.MENU;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                player.setUp(false);
            case KeyEvent.VK_S:
                player.setDown(false);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON2) {
            controller.addManaball(new Manaball(player.getxValue(), player.getyValue(), 64, 64));
        }
    }

    public void windowFocusLost() {
        player.resetDirBoolean();
    }

    public Player getPlayer() {
        return player;
    }
}
