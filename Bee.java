package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import entities.Player;

public class Bee extends Enemy{


    BufferedImage image;

    public Bee(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x, y, width, height);
        initHitbox(x , y , width, height);

    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_BEE);
    }
    public void update() {
        x -= 0.5;
        hitbox.x -= 0.5;
        if (hitbox.x==24){

        }
    }
    private int[][] lvldata;

    public void loadlvldata(int[][] lvldata){
        this.lvldata=lvldata;
    }
    public void render(Graphics g) {
        g.drawImage(image, (int) x , (int) y, width, height, null);
        drawHitbox(g);
    }

    public float getX() {
        return x;
    }



}
