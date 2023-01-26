package ui;

import entities.Score;
import gamestates.Gamestate;
import gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.Buttons.B_HEIGHT;
import static utilz.Constants.UI.Buttons.B_WIDTH;

public class GameOverOverlay {
    //GAME OVER OVERLAY
    private Playing playing;
    private BufferedImage img;
    private int imgX, imgY, imgW, imgH;
    private MenuButton menuButton, play;
    private Rectangle bounds;
    public GameOverOverlay(Playing playing){
        this.playing = playing;
        createImg();
        //createButtons();
    }

//    private void createButtons(){
//        int menuX = 100;
//        int playX = 150;
//        int y = 200;
//
//        //play = new MenuButton(playX, y, 100, GameOverOverlay,);
//    }

    //Menu
    private void createImg(){
        img = LoadSave.GetSpriteAtlas(LoadSave.DEATH_SCREEN);
        imgH = 960;
        imgW = 348;
        imgX = 300;
        imgY = 174;
    }

    public void draw(Graphics g){
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, 1920, 696);

        g.drawImage(img, imgX, imgY, imgH, imgW, null);
        g.setColor(Color.WHITE);
        g.drawString("Final Score: " + Score.currentScore, 710, 410);
        g.drawString("PRESS ESCAPE TO RETURN TO THE MAIN MENU", 550, 480);

    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            Gamestate.state = Gamestate.MENU;
            playing.resetAll();
        }
    }
}
