package ui;

import gamestates.Gamestate;
import gamestates.Playing;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverOverlay {

    private Playing playing;
    public GameOverOverlay(Playing playing){
        this.playing = playing;

    }

    //Menu

    public void draw(Graphics g){
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, 1920, 696);

        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", 700, 200);
        g.drawString("PRESS ESC TO MENU", 700, 300);
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            playing.resetAll();
            Gamestate.state = Gamestate.MENU;
        }
    }
}
