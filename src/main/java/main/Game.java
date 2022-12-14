package main;

import entities.Player;

import java.awt.*;
 //gej
public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int fpsSet = 120;
    private final int upsSet = 200;
    private Player player;
    private final static float SCALE = 2f;

    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        
        startGameLoop();
    }

     private void initClasses() {
        player = new Player(200, 200, (int)(64 * SCALE), (int)(48 * SCALE) );
     }

     private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        player.update();
    }

    //Render all entities
    public void render(Graphics g) {
        player.render(g);
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
 }
