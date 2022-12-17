package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Manaball extends Entity{

    BufferedImage image;
    int attackSpeed = 3;

    public Manaball(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.MANABALL_1);
    }

    public void update() {
        x += attackSpeed;
    }

    public void render(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);
    }

    public float getX() {
        return x;
    }
}
