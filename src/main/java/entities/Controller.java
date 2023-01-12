package entities;

import java.awt.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller extends TimerTask {

    private LinkedList<Manaball> manaBalls = new LinkedList<Manaball>();
    private LinkedList<Bat> bats = new LinkedList<>();
    private LinkedList<Bee> bees = new LinkedList<>();
    private LinkedList<Blue> blues = new LinkedList<>();
    private LinkedList<Green> greens = new LinkedList<>();
    private LinkedList<Grey> greys = new LinkedList<>();
    private LinkedList<Orange> oranges = new LinkedList<>();
    private LinkedList<Pink> pinks = new LinkedList<>();
    private LinkedList<Red> reds = new LinkedList<>();
    private LinkedList<Robot> robots = new LinkedList<>();
    private LinkedList<Yellow> yellows = new LinkedList<>();
    Manaball tempManaball;
    Bat tempBat;
    Bee tempBee;
    Blue tempBlue;
    Green tempGreen;
    Grey tempGrey;
    Orange tempOrange;
    Pink tempPink;
    Red tempRed;
    Robot tempRobot;
    Yellow tempYellow;

//    private int lastSpawnedEnemy = java.time.Instant;
    int renderTick = 0;

    public Controller() {
        TimerTask repeatedTask = new TimerTask() {
            int yValue = 0;
            public void run() {
                int min = 0;
                int max = 9;
                int minXValue = 1200;
                int maxXValue = 1800;
                int minYValue = 0;
                int maxYValue = 800;
                int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
                if (random_int == 0){
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addBat(new Bat(randomX, randomY, 64, 64));}
                else if (random_int == 1) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addBee(new Bee(randomX, randomY, 64, 64));}
                else if (random_int == 2) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addBlue(new Blue(randomX, randomY, 64, 64));}
                else if (random_int == 3) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addGreen(new Green(randomX, randomY, 64, 64));}
                else if (random_int == 4) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addGrey(new Grey(randomX, randomY, 64, 64));}
                else if (random_int == 5) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addOrange(new Orange(randomX, randomY, 64, 64));}
                else if (random_int == 6) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addPink(new Pink(randomX, randomY, 64, 64));}
                else if (random_int == 7) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addRed(new Red(randomX, randomY, 64, 64));}
                else if (random_int == 8) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addRobot(new Robot(randomX, randomY, 64, 64));}
                else if (random_int == 9) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addYellow(new Yellow(randomX, randomY, 64, 64));}
                }

        };
        Timer timer = new Timer("Timer");

        long delay = 1500L;
        long period = 1500L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);


    }

    @Override
    public void run() {}

    public void update() {
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
                if (tempBat.getX() <= tempManaball.getX() + 50 && isTouching("bat")) {
                    removeBat(tempBat);
                    removeManaball(tempManaball);
                }
            }
            tempBat.update();
        }
        for (int i = 0; i < bees.size(); i++) {
            tempBee = bees.get(i);
            if (tempManaball != null) {
                if (tempBee.getX() <= tempManaball.getX() + 50 && isTouching("bees")) {
                    removeBee(tempBee);
                    removeManaball(tempManaball);
                }
            }
            tempBee.update();
        }
        for (int i = 0; i < blues.size(); i++) {
            tempBlue = blues.get(i);
            if (tempManaball != null) {
                if (tempBlue.getX() <= tempManaball.getX() + 50 && isTouching("blue")) {
                    removeBlue(tempBlue);
                    removeManaball(tempManaball);
                }
            }
            tempBlue.update();
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
        for (int i = 0; i < bees.size(); i++) {
            tempBee = bees.get(i);
            tempBee.render(g);
        }
        for (int i = 0; i < blues.size(); i++) {
            tempBlue = blues.get(i);
            tempBlue.render(g);
        }
        for (int i = 0; i < greens.size(); i++) {
            tempGreen = greens.get(i);
            tempGreen.render(g);
        }
        for (int i = 0; i < greys.size(); i++) {
            tempGrey = greys.get(i);
            tempGrey.render(g);
        }
        for (int i = 0; i < oranges.size(); i++) {
            tempOrange = oranges.get(i);
            tempOrange.render(g);
        }
        for (int i = 0; i < pinks.size(); i++) {
            tempPink = pinks.get(i);
            tempPink.render(g);
        }
        for (int i = 0; i < reds.size(); i++) {
            tempRed = reds.get(i);
            tempRed.render(g);
        }
        for (int i = 0; i < robots.size(); i++) {
            tempRobot = robots.get(i);
            tempRobot.render(g);
        }
        for (int i = 0; i < yellows.size(); i++) {
            tempYellow = yellows.get(i);
            tempYellow.render(g);
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


    // ADDING AND REMOVING THE DIFFERENT ENEMIES
    public void addBat(Bat bat) {bats.add(bat);}
    public void removeBat(Bat bat) {bats.remove(bat);}
    public void addBee(Bee bee) {bees.add(bee);}
    public void removeBee(Bee bee) {bees.remove(bee);}
    public void addBlue(Blue blue) {blues.add(blue);}
    public void removeBlue(Blue blue) {blues.remove(blue);}
    public void addGreen(Green green) {greens.add(green);}
    public void removeGreen(Green green) {greens.remove(green);}
    public void addGrey(Grey grey) {greys.add(grey);}
    public void removeGrey(Grey grey) {greys.remove(grey);}
    public void addOrange(Orange orange) {oranges.add(orange);}
    public void removeOrange(Orange orange) {oranges.remove(orange);}
    public void addPink(Pink pink) {pinks.add(pink);}
    public void removePink(Pink pink) {pinks.remove(pink);}
    public void addRed(Red red) {reds.add(red);}
    public void removeRed(Red red) {reds.remove(red);}
    public void addRobot(Robot robot) {robots.add(robot);}
    public void removeRobot(Robot robot) {robots.remove(robot);}
    public void addYellow(Yellow yellow) {yellows.add(yellow);}
    public void removeYellow(Yellow yellow) {yellows.remove(yellow);}


    public boolean isTouching(String enemy) {
        if (enemy.equals("bat")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        } else if (enemy.equals("blue")){
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("green")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("grey")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("orange")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("pink")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("red")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("robot")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        else if (enemy.equals("yellow")) {
            if ((int) tempBat.getY() == (int) tempManaball.getY()) {
                return true;
            } else if (tempManaball.getY() <= tempBat.getY() + 50 && tempManaball.getY() + 50 >= tempBat.getY()) {
                return true;
            }
        }
        return false;
    }

}