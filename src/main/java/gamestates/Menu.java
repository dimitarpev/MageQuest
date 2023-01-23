package gamestates;

import entities.Background;
import entities.Grey;
import entities.Manaball;
import main.Game;
import ui.MenuButton;
import utilz.Constants;
import utilz.Constants.UI.Buttons.*;
import utilz.LoadSave;

import javax.imageio.ImageIO;

import static utilz.Constants.UI.Buttons.*;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class Menu extends State implements Statemethods{

    private MenuButton[] buttons = new MenuButton[2];
    private BufferedImage img;
    private BufferedImage[] animations;
    private BufferedImage backgroundImg;
    private BufferedImage gameNameImg;
    private int aniTick, aniIndex, aniSpeed = 50;
    float ticker = 0f;

    private int menuX, menuY, menuWidth, menuHeight;
    public Menu(Game game) {
        super(game);
//        loadAnimations();
        loadButtons();
        loadBackground();
        loadGameName();
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 7) {
                aniIndex = 0;

            }
        }
    }

    private void loadAnimations(){
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);

        animations = new BufferedImage[7];

        for(int i = 0; i < animations.length; i++){
            animations[i] = img.getSubimage(i * 190,0,190,160);
        }
    }
    private void loadGameName(){
        gameNameImg = LoadSave.GetSpriteAtlas(LoadSave.GAME_NAME);
    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);


    }


    private void loadButtons() {
        buttons[0] = new MenuButton( 1920/ 2,(int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
//        buttons[1] = new MenuButton(1920/ 2,(int) (220 * Game.SCALE), 1, Gamestate.OPTIONS);
        buttons[1] = new MenuButton(1920/ 2,(int) (220 * Game.SCALE) , 2, Gamestate.QUIT);
    }

    @Override
    public void update() {
        updateAnimationTick();
        for(MenuButton mb : buttons)
            mb.update();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(backgroundImg,menuX, menuY, 1920, 700, null );
//        g.drawImage(animations[aniIndex], 100, (int)(696/2 * Game.SCALE), 700,300,null);
        g.drawImage(gameNameImg,720 , 150, 500,100, null);
        for(MenuButton mb : buttons)
            mb.render(g);
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButton mb: buttons){
            if (isIn(e,mb)){
                mb.setMousePressed(true);
                break;
            }
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        for(MenuButton mb: buttons){
            if (isIn(e,mb)){
                if(mb.isMousePressed())
                    mb.applyGameState();
                break;
            }
        }
        resetButtons();
    }
    private void resetButtons() {
        for(MenuButton mb: buttons){
            mb.resetBools();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuButton mb: buttons){
            mb.setMouseOver(false);
        }
        for(MenuButton mb: buttons){
            if (isIn(e, mb)){
                mb.setMouseOver(true);
                break;
            }
        }

    }
}
