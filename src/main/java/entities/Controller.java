package entities;

import gamestates.Gamestate;

import javax.swing.text.TabStop;
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

    Player player;


    public Controller(Player player) {
        this.player = player;

        //Draw Player Hearts
        for(int i=0; i < player.livesOfPlayer;i++){
            addHeart(new Heart(3 + 32 * i,50,32,32));
        }

        //Enemy Spawning System
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                if(Gamestate.state == Gamestate.PLAYING){
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
                }}

        };
        Timer timer = new Timer("Timer");
        if(Score.currentScore < 200){
            long min = 1000L;
            long max = 1500L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
        if(Score.currentScore >= 200 && Score.currentScore < 1000){
            long min = 1500L;
            long max = 2000L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
        if(Score.currentScore >= 1000 && Score.currentScore < 5000){
            long min = 2000L;
            long max = 2500L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}
        if(Score.currentScore >= 5000){
            long min = 2500L;
            long max = 3500L;
            long delay = min + (long) (Math.random() * (max - min));
            long period = min + (long) (Math.random() * (max - min));
            timer.scheduleAtFixedRate(repeatedTask, delay, period);}


    }

    @Override
    public void run() {}

    public void update() {
        for (int i = 0; i < hearts.size(); i++) {
            tempHeart = hearts.get(i);


            tempHeart.update();
        }
        for (int i = 0; i < manaBalls.size(); i++) {
            tempManaball = manaBalls.get(i);
            if (tempManaball.getX() > 1550) {
                removeManaball(tempManaball);
            }
            tempManaball.update();
        }
        for (int i = 0; i < spikeballs.size(); i++) {
            tempSpikeball = spikeballs.get(i);
            if (tempSpikeball.getX() <= 0) {
                removeSpikeball(tempSpikeball);
            }

            //DECREASE LIFE IF SPIKEBALL HITS PLAYER
            if (spikeballs != null && player.livesOfPlayer > 0) {
                if (tempSpikeball.hitbox.intersects(player.getHitbox())) {
                    player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                    removeHeart(hearts.get(player.getLivesOfPlayer()));
                    spikeballs.remove(tempSpikeball);
                    return;
                }
            }

            //IF SPIKEBALL AND MANABALL COLLIDE REMOVE BOTH
            for (Manaball manaball : manaBalls){
                if (tempSpikeball.hitbox.intersects(manaball.hitbox)){
                    spikeballs.remove(tempSpikeball);
                    manaBalls.remove(manaball);
                }
            }


            tempSpikeball.update();
        }

        //ENEMIES
        for (int i = 0; i < bats.size(); i++) {
            tempBat = bats.get(i);

            if (tempBat.getX() <= 230) {
                removeBat(tempBat);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));

            }
            if (manaBalls != null && bats != null) {
                checkBatHit(tempBat.getHitbox(), "bat");
            }

            tempBat.update();
        }
        for (int i = 0; i < bees.size(); i++) {
            tempBee = bees.get(i);
            if (tempBee.getX() <= 230) {
                removeBee(tempBee);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
            }

            if (manaBalls != null && bees != null && checkBeeHit(tempBee.getHitbox(), "bee") ) {
                checkBeeHit(tempBee.getHitbox(), "bee");
            }

            //SEE HOW ENEMY SHOOTING WORKS /TEST CODE/
//            int maxXShootValue = 50000;
//            int minXShootValue = 0;
//            int randomIfWillShoot = (int)Math.floor(Math.random() * (maxXShootValue - minXShootValue + 1) + minXShootValue);
//            if (randomIfWillShoot < 20) {
//                addSpikeball(new Spikeball(tempBee.getX(), tempBee.getY(), 48, 48));
//            }

            tempBee.update();
        }
        for (int i = 0; i < blues.size(); i++) {
            tempBlue = blues.get(i);
            if (tempBlue.getX() <= 230) {
                removeBlue(tempBlue);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
            }
            if (manaBalls != null && blues != null) {
                checkBlueHit(tempBlue.getHitbox(), "blue");
            }

            tempBlue.update();
        }
        for (int i = 0; i < greens.size(); i++) {
            tempGreen = greens.get(i);
            if (tempGreen.getX() <= 230) {
                removeGreen(tempGreen);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
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
            if (tempGrey.getX() <= 230) {
                removeGrey(tempGrey);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
            }
            if (manaBalls != null && greys != null) {
                checkGreyHit(tempGrey.getHitbox(), "grey");
            }

            tempGrey.update();
        }
        for (int i = 0; i < oranges.size(); i++) {
            tempOrange = oranges.get(i);
            if (tempOrange.getX() <= 230) {
                removeOrange(tempOrange);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
            }
            if (manaBalls != null && oranges != null) {
                checkOrangeHit(tempOrange.getHitbox(), "orange");
            }

            tempOrange.update();
        }
        for (int i = 0; i < pinks.size(); i++) {
            tempPink = pinks.get(i);
            if (tempPink.getX() <= 230) {
                removePink(tempPink);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
            }
            if (manaBalls != null && pinks != null) {
                checkPinkHit(tempPink.getHitbox(), "pink");
            }

            tempPink.update();
        }
        for (int i = 0; i < reds.size(); i++) {
            tempRed = reds.get(i);
            if (tempRed.getX() <= 230) {
                removeRed(tempRed);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
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
            if (tempRobot.getX() <= 230) {
                removeRobot(tempRobot);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));
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
            if (tempYellow.getX() <= 230) {
                removeYellow(tempYellow);
                player.setLivesOfPlayer(player.getLivesOfPlayer() - 1);
                removeHeart(hearts.get(player.getLivesOfPlayer()));

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
                        b.blueHealth -= 1;
                        manaBalls.remove(mb);
                        if (b.blueHealth <= 0) {
                            blues.remove(b);
                            Score.currentScore += 20;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkGreenHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Green g : greens)
                if (mb != null) {

                    if (g.hitbox.intersects(mb.getHitbox())) {
                        g.greenHealth -= 1;
                        manaBalls.remove(mb);
                        if (g.greenHealth <= 0) {
                            greens.remove(g);
                            Score.currentScore += 30;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkGreyHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Grey g : greys)
                if (mb != null) {

                    if (g.hitbox.intersects(mb.getHitbox())) {
                        g.greyHealth -= 1;
                        manaBalls.remove(mb);
                        if (g.greyHealth <= 0) {
                            greys.remove(g);
                            Score.currentScore += 10;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkOrangeHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Orange o : oranges)
                if (mb != null) {

                    if (o.hitbox.intersects(mb.getHitbox())) {
                        o.orangeHealth -= 1;
                        manaBalls.remove(mb);
                        if (o.orangeHealth <= 0) {
                            oranges.remove(o);
                            Score.currentScore += 20;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkPinkHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Pink p : pinks)
                if (mb != null) {

                    if (p.hitbox.intersects(mb.getHitbox())) {
                        p.pinkHealth -= 1;
                        manaBalls.remove(mb);
                        if (p.pinkHealth <= 0) {
                            pinks.remove(p);
                            Score.currentScore += 10;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkRedHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Red r : reds)
                if (mb != null) {

                    if (r.hitbox.intersects(mb.getHitbox())) {
                        r.redHealth -= 1;
                        manaBalls.remove(mb);
                        if (r.redHealth <= 0) {
                            reds.remove(r);
                            Score.currentScore += 30;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkRobotHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Robot r : robots)
                if (mb != null) {

                    if (r.hitbox.intersects(mb.getHitbox())) {
                        r.robotHealth -= 1;
                        manaBalls.remove(mb);
                        if (r.robotHealth <= 0) {
                            robots.remove(r);
                            Score.currentScore += 40;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkYellowHit(Rectangle2D.Float hitbox, String enemyType) {
        for(Manaball mb : manaBalls)
            for (Yellow y : yellows)
                if (mb != null) {

                    if (y.hitbox.intersects(mb.getHitbox())) {
                        y.yellowHealth -= 1;
                        manaBalls.remove(mb);
                        if (y.yellowHealth <= 0) {
                            yellows.remove(y);
                            Score.currentScore += 30;
                            return;
                        }
                        return;
                    }
                }
    }
    public void checkBatHit(Rectangle2D.Float hitbox, String enemyType) {
        if (enemyType.equals("bat")){
            for(Manaball mb : manaBalls)
                for (Bat b : bats)
                    if (mb != null) {

                        if (b.hitbox.intersects(mb.getHitbox())) {
                            b.batHealth -= 1;
                            manaBalls.remove(mb);
                            if (b.batHealth <= 0) {
                                bats.remove(b);
                                Score.currentScore += 20;
                                return;
                            }
                            return;
                        }
                    }
        }
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



}