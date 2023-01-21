package entities;

import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Entity{

    BufferedImage heartImage;
    public Enemy(float x, float y, int height, int width) {
        super(x, y, height, width);
        heartImage = LoadSave.GetSpriteAtlas(LoadSave.HEART);
    }

    public void update() {

    }

    public void displayEnemyHP(Graphics g, int hp){
        if (hp == 4) {
            g.drawImage(heartImage, (int)x + 30, (int)y + 60, 10, 10, null);
            g.drawImage(heartImage, (int)x + 40, (int)y + 60, 10, 10, null);
            g.drawImage(heartImage, (int)x + 50, (int)y + 60, 10, 10, null);
            g.drawImage(heartImage, (int)x + 60, (int)y + 60, 10, 10, null);
        }
        else if (hp == 3) {
            g.drawImage(heartImage, (int)x + 40, (int)y + 60, 10, 10, null);
            g.drawImage(heartImage, (int)x + 50, (int)y + 60, 10, 10, null);
            g.drawImage(heartImage, (int)x + 60, (int)y + 60, 10, 10, null);
        }
        else if (hp == 2) {
            g.drawImage(heartImage, (int)x + 50, (int)y + 60, 10, 10, null);
            g.drawImage(heartImage, (int)x + 60, (int)y + 60, 10, 10, null);
        } else if (hp == 1) {
            g.drawImage(heartImage, (int)x + 60, (int)y + 60, 10, 10, null);
        }
    }
}
