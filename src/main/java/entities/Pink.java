package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pink extends Enemy{
    //ENEMY PINK CLASS - LEVEL 1 ENEMY
    BufferedImage image;
    float speed = 1.2f;
    int pinkHealth = 1;
    public Pink(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_PINK);
    }


    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);

        //DISPLAY ENEMY HP
        displayEnemyHP(g, pinkHealth);
    }

    @Override
    public void update() {
        x -= speed;
        hitbox.x -= speed;
    }

    public float getX() {return x;}

    public int getPinkHealth(){return pinkHealth;}
    public void setPinkHealth(int pinkHealth){this.pinkHealth = pinkHealth;}

}
