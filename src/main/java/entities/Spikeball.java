package entities;

import main.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spikeball extends Entity{
    //ENEMY SHOTS CLASS
    BufferedImage image;
    float attackSpeed = 1.5f;
    private float xDrawOffset = 50 * Game.SCALE;
    private float yDrawOffset = 53 * Game.SCALE;

    public Spikeball(float x, float y, int height, int width) {
        super(x, y, height, width);
        assignImage();
        initHitbox(x  , y , 48, 48);
    }

    private void assignImage() {
        image = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_SHOT);
    }

    public void update() {
        //MOVE ENEMY SHOTS TOWARDS PLAYER
        x -= attackSpeed;
        hitbox.x -= attackSpeed;
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
