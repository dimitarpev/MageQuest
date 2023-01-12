package entities;

import java.awt.*;

public class Score {

    public static int currentScore = 0;

    public Score() {

    }

    public void render(Graphics g) {
        Font textFont = new Font("ROMAN_BASELINE", Font.BOLD, 18);
        g.setFont(textFont);
        g.setColor(Color.CYAN);
        g.drawString("SCORE:", 10, 30);
        g.drawString(Integer.toString(currentScore), 80, 30 );
    }

    public void update() {

    }

}