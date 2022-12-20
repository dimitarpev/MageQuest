package entities;

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    private LinkedList<Manaball> manaBalls = new LinkedList<Manaball>();
    Manaball tempManaball;
    int renderTick = 0;

    public Controller() {

    }

    public void update(){
            for (int i = 0; i < manaBalls.size(); i++) {
                tempManaball = manaBalls.get(i);

                if (tempManaball.getX() > 1920) {
                    removeManaball(tempManaball);
                }

                tempManaball.update();
            }
    }

    public void render(Graphics g) {
        for (int i = 0; i < manaBalls.size(); i++) {
            tempManaball = manaBalls.get(i);

            tempManaball.render(g);

        }
//        renderTick++;
//        if (renderTick == 100) {
//            renderTick = 0;
//        }
    }

    public void addManaball(Manaball ball) {
        manaBalls.add(ball);
    }
    public void removeManaball(Manaball ball) {
        manaBalls.remove(ball);
    }

}
