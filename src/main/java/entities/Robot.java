package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Robot extends Enemy{
    //ENEMY ROBOT CLASS - LEVEL 4 ENEMY
    BufferedImage image;
    float speed = 0.5f;
    int robotHealth = 4;
    public Robot(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_ROBOT);
    }


    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);

        //DISPLAY ENEMY HP
        displayEnemyHP(g, robotHealth);
    }

    @Override
    public void update() {
        x -= speed;
        hitbox.x -= speed;
    }

    public float getX() {return x;}
    public float getY() {
        return  y;
    }

    public int getRobotHealth(){return robotHealth;}
    public void setRobotHealth(int robotHealth){this.robotHealth = robotHealth;}

}
