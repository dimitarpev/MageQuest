package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static utilz.Constants.EnemyConstants.*;

public class Square extends Enemy{
    //TEST CLASS FOR THE ENEMY CREATION /NOT USED IN FINAL GAME/
    public Square(float x, float y) {
        super(x, y, SQUARE_HEIGHT, SQUARE_WIDTH);
        initHitbox(x, y, width, height);

    }

    public void render(Graphics g) {
        g.fillRect((int)x, (int)y, SQUARE_WIDTH, SQUARE_HEIGHT);
        drawHitbox(g);
    }

    public void checkEnemyHit(Rectangle2D.Float hitbox) {
        if (hitbox.intersects(this.hitbox)){
            System.out.println("HiT!");
        }
    }
}


