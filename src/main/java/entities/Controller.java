package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


public class Controller extends TimerTask {

    private LinkedList<Manaball> manaBalls = new LinkedList<Manaball>();
    private LinkedList<Spikeball> spikeballs = new LinkedList<>();
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
    private LinkedList<Heart> hearts = new LinkedList<>();

    Manaball tempManaball;
    Spikeball tempSpikeball;
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
    Heart tempHeart;

//    private int lastSpawnedEnemy = java.time.Instant;
    int renderTick = 0;

    public Controller() {
//        for(int i=0; i<3;i++){
//            addHeart(new Heart(150 + 32 * i,50,32,32));
//        }
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                int min = 0;
                int max = 0;
                if (Score.currentScore == 0){
                    max = 0;
                } else if (Score.currentScore < 200) {
                    max = 2;
                } else if (Score.currentScore > 200 && Score.currentScore < 1000) {
                    max = 5;
                } else if (Score.currentScore > 1000 && Score.currentScore < 5000) {
                    max = 8;
                } else if (Score.currentScore > 5000) {
                    max = 9;
                }
                int minXValue = 1600;
                int maxXValue = 1600;
                int minYValue = 100;
                int maxYValue = 600;
                int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
                if (random_int == 3){
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addBat(new Bat(randomX, randomY, 64, 64));}
                else if (random_int == 0) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addBee(new Bee(randomX, randomY, 64, 64));}
                else if (random_int == 4) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addBlue(new Blue(randomX, randomY, 64, 64));}
                else if (random_int == 6) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addGreen(new Green(randomX, randomY, 64, 64));}
                else if (random_int == 1) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addGrey(new Grey(randomX, randomY, 64, 64));}
                else if (random_int == 5) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addOrange(new Orange(randomX, randomY, 64, 64));}
                else if (random_int == 2) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addPink(new Pink(randomX, randomY, 64, 64));}
                else if (random_int == 7) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addRed(new Red(randomX, randomY, 64, 64));}
                else if (random_int == 9) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addRobot(new Robot(randomX, randomY, 64, 64));}
                else if (random_int == 8) {
                    int randomX = (int)Math.floor(Math.random() * (maxXValue - minXValue + 1) + minXValue);
                    int randomY = (int)Math.floor(Math.random() * (maxYValue - minYValue + 1) + minYValue);
                    addYellow(new Yellow(randomX, randomY, 64, 64));}
                }

        };
        Timer timer = new Timer("Timer");
        if(Score.currentScore < 200){
            long min = 1000L;
            long max = 3000L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
        if(Score.currentScore > 200 && Score.currentScore < 1000){
            long min = 1000L;
            long max = 3000L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
        if(Score.currentScore > 1000 && Score.currentScore < 5000){
            long min = 1000L;
            long max = 3000L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
        if(Score.currentScore > 5000){
            long min = 1000L;
            long max = 3000L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
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
        for (int i = 0; i < spikeballs.size(); i++) {
            tempSpikeball = spikeballs.get(i);
            if (tempSpikeball.getX() == 0) {
                removeSpikeball(tempSpikeball);
            }
            tempSpikeball.update();
        }


        for (int i = 0; i < bats.size(); i++) {
            tempBat = bats.get(i);

            if (tempBat.getX() == 0) {
                removeBat(tempBat);
            }
            if (manaBalls != null && bats != null) {
                checkEnemyHit(tempBat.getHitbox(), "bat");
            }

//          SEE HOW ENEMY SHOOTING WORKS /TEST CODE/
//            int maxXShootValue = 50000;
//            int minXShootValue = 0;
//            int randomIfWillShoot = (int)Math.floor(Math.random() * (maxXShootValue - minXShootValue + 1) + minXShootValue);
//            if (randomIfWillShoot < 20) {
//                addSpikeball(new Spikeball(tempBat.getX(), tempBat.getY(), 48, 48));
//            }

            tempBat.update();
        }
        for (int i = 0; i < bees.size(); i++) {
            tempBee = bees.get(i);
            if (tempBee.getX() == 0) {
                removeBee(tempBee);
            }

            if (manaBalls != null && bees != null && checkBeeHit(tempBee.getHitbox(), "bee") ) {
                checkBeeHit(tempBee.getHitbox(), "bee");
            }

            tempBee.update();
        }
        for (int i = 0; i < blues.size(); i++) {
            tempBlue = blues.get(i);
            if (tempBlue.getX() == 0) {
                removeBlue(tempBlue);
            }
            if (manaBalls != null && blues != null) {
                checkBlueHit(tempBlue.getHitbox(), "blue");
            }

            tempBlue.update();
        }
        for (int i = 0; i < greens.size(); i++) {
            tempGreen = greens.get(i);
            if (tempGreen.getX() == 0) {
                removeGreen(tempGreen);
            }
            if (manaBalls != null && greens != null) {
                checkGreenHit(tempGreen.getHitbox(), "green");
            }
            int maxGreenShootValue = 50000;
            int minGreenShootValue = 0;
            int randomIfWillShoot = (int)Math.floor(Math.random() * (maxGreenShootValue - minGreenShootValue + 1) + minGreenShootValue);
            if (randomIfWillShoot < 20) {
                addSpikeball(new Spikeball(tempGreen.getX(), tempGreen.getY(), 48, 48));
            }

            tempGreen.update();
        }
        for (int i = 0; i < greys.size(); i++) {
            tempGrey = greys.get(i);
            if (tempGrey.getX() == 0) {
                removeGrey(tempGrey);
            }
            if (manaBalls != null && greys != null) {
                checkGreyHit(tempGrey.getHitbox(), "grey");
            }

            tempGrey.update();
        }
        for (int i = 0; i < oranges.size(); i++) {
            tempOrange = oranges.get(i);
            if (tempOrange.getX() == 0) {
                removeOrange(tempOrange);
            }
            if (manaBalls != null && oranges != null) {
                checkOrangeHit(tempOrange.getHitbox(), "orange");
            }

            tempOrange.update();
        }
        for (int i = 0; i < pinks.size(); i++) {
            tempPink = pinks.get(i);
            if (tempPink.getX() == 0) {
                removePink(tempPink);
            }
            if (manaBalls != null && pinks != null) {
                checkPinkHit(tempPink.getHitbox(), "pink");
            }

            tempPink.update();
        }
        for (int i = 0; i < reds.size(); i++) {
            tempRed = reds.get(i);
            if (tempRed.getX() == 0) {
                removeRed(tempRed);
            }
            if (manaBalls != null && reds != null) {
                checkRedHit(tempRed.getHitbox(), "red");
            }
            int maxRedShootValue = 50000;
            int minRedShootValue = 0;
            int randomIfWillShoot = (int)Math.floor(Math.random() * (maxRedShootValue - minRedShootValue + 1) + minRedShootValue);
            if (randomIfWillShoot < 20) {
                addSpikeball(new Spikeball(tempRed.getX(), tempRed.getY(), 48, 48));
            }

            tempRed.update();
        }
        for (int i = 0; i < robots.size(); i++) {
            tempRobot = robots.get(i);
            if (tempRobot.getX() == 0) {
                removeRobot(tempRobot);
            }
            if (manaBalls != null && robots != null) {
                checkRobotHit(tempRobot.getHitbox(), "robot");
            }

            int maxXShootValue = 50000;
            int minXShootValue = 0;
            int randomIfWillShoot = (int)Math.floor(Math.random() * (maxXShootValue - minXShootValue + 1) + minXShootValue);
            if (randomIfWillShoot < 20) {
                addSpikeball(new Spikeball(tempRobot.getX(), tempRobot.getY(), 48, 48));
            }


            tempRobot.update();
        }
        for (int i = 0; i < yellows.size(); i++) {
            tempYellow = yellows.get(i);
            if (tempYellow.getX() == 0) {
                removeYellow(tempYellow);
            }
            if (manaBalls != null && yellows != null) {
                checkYellowHit(tempYellow.getHitbox(), "yellow");
            }

            int maxXShootValue = 50000;
            int minXShootValue = 0;
            int randomIfWillShoot = (int)Math.floor(Math.random() * (maxXShootValue - minXShootValue + 1) + minXShootValue);
            if (randomIfWillShoot < 20) {
                addSpikeball(new Spikeball(tempYellow.getX(), tempYellow.getY(), 48, 48));
            }

            tempYellow.update();
        }
    }

    public boolean checkBeeHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Bee b : bees)
                if (mb != null) {

                    if (b.hitbox.intersects(mb.getHitbox())) {
                        bees.remove(b);
                        manaBalls.remove(mb);
                        Score.currentScore += 10;
                        return true;
                    }
                }
        return false;
    }
    public void checkBlueHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Blue b : blues)
                if (mb != null) {

                    if (b.hitbox.intersects(mb.getHitbox())) {
                        blues.remove(b);
                        manaBalls.remove(mb);
                        Score.currentScore += 20;
                        return;
                    }
                }
    }
    public void checkGreenHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Green g : greens)
                if (mb != null) {

                    if (g.hitbox.intersects(mb.getHitbox())) {
                        greens.remove(g);
                        manaBalls.remove(mb);
                        Score.currentScore += 30;
                        return;
                    }
                }
    }
    public void checkGreyHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Grey g : greys)
                if (mb != null) {

                    if (g.hitbox.intersects(mb.getHitbox())) {
                        greys.remove(g);
                        manaBalls.remove(mb);
                        Score.currentScore += 10;
                        return;
                    }
                }
    }
    public void checkOrangeHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Orange o : oranges)
                if (mb != null) {

                    if (o.hitbox.intersects(mb.getHitbox())) {
                        oranges.remove(o);
                        manaBalls.remove(mb);
                        Score.currentScore += 20;
                        return;
                    }
                }
    }
    public void checkPinkHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Pink p : pinks)
                if (mb != null) {

                    if (p.hitbox.intersects(mb.getHitbox())) {
                        pinks.remove(p);
                        manaBalls.remove(mb);
                        Score.currentScore += 10;
                        return;
                    }
                }
    }
    public void checkRedHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Red r : reds)
                if (mb != null) {

                    if (r.hitbox.intersects(mb.getHitbox())) {
                        reds.remove(r);
                        manaBalls.remove(mb);
                        Score.currentScore += 30;
                        return;
                    }
                }
    }
    public void checkRobotHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Robot r : robots)
                if (mb != null) {

                    if (r.hitbox.intersects(mb.getHitbox())) {
                        robots.remove(r);
                        manaBalls.remove(mb);
                        Score.currentScore += 40;
                        return;
                    }
                }
    }
    public void checkYellowHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Yellow y : yellows)
                if (mb != null) {

                    if (y.hitbox.intersects(mb.getHitbox())) {
                        yellows.remove(y);
                        manaBalls.remove(mb);
                        Score.currentScore += 30;
                        return;
                    }
                }
    }
    public void checkEnemyHit(Rectangle2D.Float hitbox, String enemyType) {
        if (enemyType.equals("bat")){
            for(Manaball mb : manaBalls)
                for (Bat b : bats)
                    if (mb != null) {

                        if (b.hitbox.intersects(mb.getHitbox())) {
                            bats.remove(b);
                            manaBalls.remove(mb);
                            Score.currentScore += 20;
                            return;
                        }
                    }}
//        if (enemyType.equals("bee")){
//            for (Bee b : bees)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            bees.remove(b);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("blue")){
//            for (Blue b : blues)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            blues.remove(b);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("green")){
//            for (Green g : greens)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            greens.remove(g);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("grey")){
//            for (Grey g : greys)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            greys.remove(g);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("orange")){
//            for (Orange o : oranges)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            oranges.remove(o);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("pink")){
//            for (Pink p : pinks)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            pinks.remove(p);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("red")){
//            for (Red r : reds)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            reds.remove(r);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("robot")){
//            for (Robot r : robots)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            robots.remove(r);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}
//        if (enemyType.equals("yellow")){
//            for (Yellow y : yellows)
//                for(Manaball mb : manaBalls)
//                    if (mb != null) {
//
//                        if (hitbox.intersects(mb.getHitbox())) {
//                            yellows.remove(y);
//                            manaBalls.remove(mb);
//                            return;
//                        }
//                    }}

    }

    public void render(Graphics g) {
        for (int i = 0; i < manaBalls.size(); i++) {
            tempManaball = manaBalls.get(i);
            tempManaball.render(g);
        }
        for (int i = 0; i < spikeballs.size(); i++) {
            tempSpikeball = spikeballs.get(i);
            tempSpikeball.render(g);
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
        for (int i = 0; i < hearts.size(); i++) {
            tempHeart = hearts.get(i);
            tempHeart.render(g);
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
    public void addSpikeball(Spikeball ball) {
        spikeballs.add(ball);
    }
    public void removeSpikeball(Spikeball ball) {
        spikeballs.remove(ball);
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
    public void addHeart(Heart heart){ hearts.add(heart);}
    public void removeHeart(Heart heart){ hearts.remove(heart);}

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