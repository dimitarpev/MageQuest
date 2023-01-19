package main;

import entities.*;
import gamestates.Gamestate;
import gamestates.Menu;
import gamestates.Playing;

import java.awt.*;
import java.util.LinkedList;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int fpsSet = 120;
    private final int upsSet = 200;
    private Playing playing;
    private Menu menu;
    private Background background;
    private Controller controller;
//    private Player player;
    private Score score;
    private Heart heart;

    public final static float SCALE = 2f;

    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

     private void initClasses() {
        menu = new Menu(this);
        playing = new Playing(this);

     }

     private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        switch (Gamestate.state){
            case MENU :
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            default:
                break;
        }
    }

    //Render all entities
    public void render(Graphics g) {
        switch (Gamestate.state){
            case MENU :
                menu.render(g);
                break;
            case PLAYING:
                playing.render(g);
                break;
            default:
                break;
        }

        //SCORE TEXT
//        Font textFont = new Font("ROMAN_BASELINE", Font.BOLD, 18);
//        g.setFont(textFont);
//        g.setColor(Color.CYAN);
//        g.drawString("SCORE", 10, 30);

    }

    //GAME LOOP
    @Override
    public void run() {
        double timePerFrame = 1000000000.00 / fpsSet;
        double timePerUpdate = 1000000000.00 / upsSet;
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

//     public Player getPlayer() {
//         return player;
//     }
     public Background getBackground() {
        return background;
     }
     public Controller getController() {
        return controller;
    }
    public void windowFocusLost() {
        if (Gamestate.state == Gamestate.PLAYING){
            playing.getPlayer().resetDirBoolean();
        }

    }
    public Menu getMenu(){
        return menu;
    }
    public Playing getPlaying(){
        return playing;
    }
}
