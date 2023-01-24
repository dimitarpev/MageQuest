package entities;

import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Manaball extends Entity{
    //PLAYER SHOTS CLASS
    BufferedImage image;
    int attackSpeed = 3;
    private float xDrawOffset = 50 * Game.SCALE;
    private float yDrawOffset = 53 * Game.SCALE;

    public Manaball(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x + 50 , y + 53, 31, 22);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.MANABALL_2);
    }

    public void update() {
        //MOVES MANABALL TOWARDS ENEMIES DEPENDING ON attackSpeed var
        x += attackSpeed;
        hitbox.x += attackSpeed;
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
}
