package entities;

import java.awt.*;

public class Score {
    //PLAYER'S SCORE CLASS
    public static int currentScore = 0;

    public Score() {

    }

    public void render(Graphics g) {
        //DRAW SCORE AND CHANGE COLOR DEPENDING ON ITS VALUE
        Font textFont = new Font("ROMAN_BASELINE", Font.BOLD, 18);
        g.setFont(textFont);
        if (currentScore < 200)
            g.setColor(Color.CYAN);
        else if (currentScore >= 200 && currentScore < 1000) {
            g.setColor(Color.orange);
        } else if (currentScore >= 1000 && currentScore < 5000) {
            g.setColor(Color.red);
        } else if (currentScore >= 5000) {
            g.setColor(Color.BLACK);
        }
        g.drawString("SCORE: " + currentScore , 10, 30);

        //DRAW TUTORIAL MESSAGES
        if (currentScore < 20) {
        g.drawString("PRESS SPACE TO SHOOT!", 500, 10);}
//        g.drawString(Integer.toString(currentScore), 80, 30 );
    }

    public void update() {

    }
    public int getScore(){return currentScore;}

    public int getCurrentScore() {
        return currentScore;
    }
    public void setCurrentScore(int currentScore) {
        Score.currentScore = currentScore;
    }

}
