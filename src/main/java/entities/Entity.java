package entities;

import java.awt.image.BufferedImage;

public abstract class Entity {
    //Abstract class for all entities
    protected float x, y;
    protected int width, height;

    public Entity(float x, float y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

}
