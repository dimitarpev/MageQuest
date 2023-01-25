package gamestates;

import entities.*;
import main.Game;
import ui.GameOverOverlay;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.event.MouseEvent.*;


public class Playing extends State implements Statemethods{
    //CLASS RUNNING WHEN GAME IN PLAYING STATE
    private Player player;
    private Manaball manaball;
    private GameOverOverlay gameOverOverlay;
    private Score score;
    private Controller controller;
    boolean canShoot = false;
    private Background background;
    private boolean gameOver;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    //INITIALISE ALL CLASSES USED IN THE GAME
    private void initClasses() {
        background = new Background(0, 0, 696, 1920);
        player = new Player(150, 200, (int)(64 * Game.SCALE), (int)(48 * Game.SCALE), this );
        controller = new Controller(player);
        score = new Score();
        gameOverOverlay = new GameOverOverlay(this);
    }

    @Override
    //UPDATE CLASSES
    public void update() {
        if (!gameOver) {
            player.update();
            controller.update();
        }
//        else {
//            Score.currentScore = 0;
//            player.livesOfPlayer = 3;
//
//        }
    }

    @Override
    //RENDER CLASSES
    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        controller.render(g);
        score.render(g);

        if (gameOver){
            gameOverOverlay.draw(g);
        }
    }

    public void resetAll(){

    }

    public void setGameOver(boolean gameOver){
        this.gameOver = gameOver;
    }

    //PLAYER KEYBOARD AND MOUSE INPUTS
    public void keyPressed(KeyEvent e) {
        if (gameOver)
            gameOverOverlay.keyPressed(e);

        else
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> player.setUp(true);
            case KeyEvent.VK_S -> player.setDown(true);
            case KeyEvent.VK_SPACE -> {
                if (player.getCANSHOOT()) {
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
//        if (e.getButton() == MouseEvent.BUTTON2) {
//            controller.addManaball(new Manaball(player.getxValue(), player.getyValue(), 64, 64));
//        }

//        switch (e.getButton()) {
//            case BUTTON1 -> {
//                if (player.CANSHOOT) {
//                    controller.addManaball(new Manaball(player.getxValue() + 30, player.getyValue() - 30, 128, 128));
//                    player.setCANSHOOT(canShoot);
//                }
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    public void windowFocusLost() {
        player.resetDirBoolean();
    }

    public Player getPlayer() {
        return player;
    }
}
