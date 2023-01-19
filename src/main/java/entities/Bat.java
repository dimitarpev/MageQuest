package entities;

import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bat extends Enemy{


    BufferedImage image;
    float speed = 1.0f;
    int batHealth = 2;
    public Bat(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);

    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_BAT);
    }

    public void update() {
        x -= speed;
        hitbox.x -= speed;

    }

    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getBatHealth(){return batHealth;}
    public void setBatHealth(int batHealth){this.batHealth = batHealth;}


}
