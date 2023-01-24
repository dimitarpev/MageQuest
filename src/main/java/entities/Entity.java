package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class Entity {
    //Abstract class for all entities
    protected float x, y;
    protected int width, height;

    protected Rectangle2D.Float hitbox;

    public Entity(float x, float y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    //DRAWS THE HITBOX OF ALL ENTITIES WHEN UNCOMMENTED
    protected void drawHitbox(Graphics g) {
        //g.setColor(Color.pink);
        //g.drawRect((int)hitbox.x, (int) hitbox.y,(int) hitbox.width,(int) hitbox.height);
    }
    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

}
