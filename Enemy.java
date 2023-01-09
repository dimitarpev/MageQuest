package entities;

public abstract class Enemy extends Entity{

    private int anindex , enemyState , enemyType;
    private int anTick , anSpeed=35;

    public Enemy(float x, float y, int height, int width) {
        super(x, y, height, width);

    }

    public void update() {

    }
}
