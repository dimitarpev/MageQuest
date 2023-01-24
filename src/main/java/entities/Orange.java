package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Orange extends Enemy {
    //ENEMY ORANGE CLASS - LEVEL 2 ENEMY
    BufferedImage image;
    float speed = 1.0f;
    int orangeHealth = 2;
    public Orange(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x, y, width, height);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_ORANGE);
    }


    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);
        drawHitbox(g);

        //DISPLAY ENEMY HP
        displayEnemyHP(g, orangeHealth);
    }

    @Override
    public void update() {
        x -= speed;
        hitbox.x -= speed;
    }

    public float getX() {
        return x;
    }

    public int getOrangeHealth(){return orangeHealth;}
    public void setOrangeHealth(int orangeHealth){this.orangeHealth = orangeHealth;}

}
