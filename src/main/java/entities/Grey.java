package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Grey extends Enemy{
    //ENEMY GREY CLASS - LEVEL 1 ENEMY
    BufferedImage image;
    float speed = 1.2f;
    int greyHealth = 1;
    public Grey(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_GREY);
    }


    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);

        //DISPLAY ENEMY HP
        displayEnemyHP(g, greyHealth);
    }

    @Override
    public void update() {
        x -= speed;
        hitbox.x -= speed;
    }

    public float getX() {return x;}

    public int getGreyHealth(){return greyHealth;}
    public void setGreyHealth(int greyHealth){this.greyHealth = greyHealth;}

}
