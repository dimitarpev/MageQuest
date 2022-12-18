package entities;

import inputs.KeyboardInputs;
import main.GamePanel;
import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static utilz.Constants.Directions.*;
import static utilz.Constants.Directions.DOWN;


public class Player extends Entity{



    private BufferedImage[] animations;
    BufferedImage imgs;
    private int aniTick, aniIndex, aniSpeed = 35;
    private float xValue = x;
    private float yValue = y;
    private int playerDir = -1;
    private boolean moving = false;


    public Player(float x, float y , int width, int height) {

        super(x, y, width, height);
        loadAnimations();

        setDefaultValues();
        getPlayerImage();
    }

    private void loadAnimations() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.IDLE_PLAYER_ATLAS);


        animations = new BufferedImage[5];
        for (int i = 0; i < 5; i++) {
            //animations[i] = img.getSubimage(i*387, 0, 387, 350);
            animations[i] = img.getSubimage(i*64, 0, 64, 58);
        }


    }


    public void setDefaultValues() {

        //speed=?

    }


    public void getPlayerImage()
    {


//       if (Kbi.upP=true){
//
//          getClass().getResourceAsStream("1_RUN_004.png");
//       }else getClass().getResourceAsStream("1_IDLE_000.png");
//
//        if (Kbi.downP=true){
//            getClass().getResourceAsStream("1_RUN_004.png");
//        }else getClass().getResourceAsStream("1_IDLE_000.png");

    }

    public void render(Graphics g) {
        g.drawImage(animations[aniIndex], (int)x, (int)y, width, height, null);
    }

    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }

    private void updatePos() {
        if(moving)
        {
            switch (playerDir){
                case LEFT:
                    x -= 5;
                    break;
                case UP:
                    y -= 5;
                    break;
                case RIGHT:
                    x += 5;
                    break;
                case DOWN:
                    y += 5;
                    break;
            }
        }
    }

    public void update() {
        //character movement with grid jumps
        updateAnimationTick();
        setAnimation();
        updatePos();


    }

    private void setAnimation() {
        //set animation if sprite is whole
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 5) {
                aniIndex = 0;
            }
        }
    }

    public float getxValue() {
        return xValue;
    }

    public float getyValue(){
        return yValue;
    }


}

