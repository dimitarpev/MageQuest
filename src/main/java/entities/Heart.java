package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Heart extends Enemy{
    BufferedImage image;

    public Heart(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
    }
    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.HEART);
    }

    public void render(Graphics g) {
        g.drawImage(image, (int)x , (int)y, 32, 32, null);
    }

    public void update(){

    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
