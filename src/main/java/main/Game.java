package main;

import entities.Background;
import entities.Controller;
import entities.Player;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int fpsSet = 120;
    private final int upsSet = 200;
    private Player player;
    private Background background;
    private Controller controller;
    public final static float SCALE = 2f;

    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        
        startGameLoop();
    }

     private void initClasses() {
         background = new Background(0, 0, 696, 1920);
         player = new Player(150, 200, (int)(64 * SCALE), (int)(48 * SCALE) );
         controller = new Controller();
     }

     private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        player.update();
        controller.update();
    }

    //Render all entities
    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        controller.render(g);
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

     public Player getPlayer() {
         return player;
     }
     public Background getBackground() {
        return background;
     }
     public Controller getController() {
        return controller;
    }

    public void windowFocusLost() {
        player.resetDirBoolean();
    }
}
