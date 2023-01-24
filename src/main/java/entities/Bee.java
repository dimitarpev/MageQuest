package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bee extends Enemy {
    //ENEMY BEE CLASS - LEVEL 1 ENEMY
    BufferedImage image;
    float speed = 1.2f;
    int beeHealth = 1;


    public Bee(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_BEE);
    }


    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);

        displayEnemyHP(g, beeHealth);
    }

    @Override
    public void update() {
        x -= speed;
        hitbox.x -= speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getBeeHealth(){return beeHealth;}
    public void setBeeHealth(int beeHealth){this.beeHealth = beeHealth;}
}
