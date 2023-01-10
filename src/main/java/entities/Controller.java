package entities;

import java.awt.*;
import java.util.LinkedList;

public class Controller {

    private LinkedList<Manaball> manaBalls = new LinkedList<Manaball>();
    private LinkedList<Bat> bats = new LinkedList<>();
    Manaball tempManaball;
    Bat tempBat;

    int renderTick = 0;

    public Controller() {
        addBat(new Bat(1200, 100, 64, 64));
    }

    public void update(){
            for (int i = 0; i < manaBalls.size(); i++) {
                tempManaball = manaBalls.get(i);

                if (tempManaball.getX() > 1920) {
                    removeManaball(tempManaball);
                }

                tempManaball.update();
            }
        for (int i = 0; i < bats.size(); i++) {
            tempBat = bats.get(i);
            if (tempManaball != null) {
                if (tempBat.getX() <= tempManaball.getX() + 50){
                    removeBat(tempBat);
                }
            }


            tempBat.update();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < manaBalls.size(); i++) {
            tempManaball = manaBalls.get(i);

            tempManaball.render(g);

        }
        for (int i = 0; i < bats.size(); i++) {
            tempBat = bats.get(i);

            tempBat.render(g);

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
    public void addBat(Bat bat) {
        bats.add(bat);
    }
    public void removeBat(Bat bat) {bats.remove(bat);}

}
