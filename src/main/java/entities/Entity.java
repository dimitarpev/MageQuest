package entities;

import java.awt.image.BufferedImage;

public abstract class Entity {
    //Abstract class for all entities
    protected float x, y;

    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }

}
