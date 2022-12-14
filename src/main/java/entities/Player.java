package entities;

import inputs.KeyboardInputs;
import main.GamePanel;
import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{



    private BufferedImage[] animations;
    private int aniTick, aniIndex, aniSpeed = 25;



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

    public void update() {

        //character movement with grid jumps
        updateAnimationTick();
        setAnimation();


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


}

