package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Green extends Enemy{
    //ENEMY GREEN CLASS - LEVEL 3 ENEMY
    BufferedImage image;
    float speed = 0.8f;
    int greenHealth = 3;
    public Green(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_GREEN);
    }


    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);

        //DISPLAY ENEMY HP
        displayEnemyHP(g, greenHealth);
    }

    @Override
    public void update() {
        x -= speed;
        hitbox.x -= speed;
    }

    public float getX() {return x;}
    public float getY() {return y;}

    public int getGreenHealth(){return greenHealth;}
    public void setGreenHealth(int greenHealth){this.greenHealth = greenHealth;}

}

