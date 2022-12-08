package main;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int fpsSet = 120;
    private final int upsSet = 200;

    public Game() {
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {

    }

    //Render all entities
    public void render(Graphics g) {

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
}
