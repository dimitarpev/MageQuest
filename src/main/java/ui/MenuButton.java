package ui;

import gamestates.Gamestate;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.Buttons.*;

public class MenuButton {
    //BUTTONS FOR MAIN MENU
private int xOffsetCenter = B_WIDTH / 2;
    private int xPos, yPos, rowIndex, index;
    private Gamestate state;
    private BufferedImage[] imgs;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
        innitBounds();
    }

    private void innitBounds() {
        bounds = new Rectangle( xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
    }

    public void loadImgs(){
        imgs = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
        for(int i = 0; i < imgs.length; i++){
            imgs[i] = temp.getSubimage(i * B_WITH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WITH_DEFAULT, B_HEIGHT_DEFAULT);
        }
    }
    public void render(Graphics g){
        g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
    }

    public void update(){
        index = 0;
        if(mouseOver)
            index = 1;
        if(mousePressed)
            index = 2;
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }
    public Rectangle getBounds(){
        return bounds;
    }
    public void applyGameState(){
        Gamestate.state = state;
    }
    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }

}
