package entities;

import main.Game;

import java.awt.*;
import java.util.ArrayList;

import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {
    //PREVIOUS TEST CLASS CURRENTLY NOT USED FOR ENEMY FUNCTIONALITY
    private Game game;
    private ArrayList<Square> squares = new ArrayList<>();

    public EnemyManager(Game game) {
        this.game = game;
    }

    public void update() {
        for (Square square : squares) {
            square.update();
        }
    }

    public void render(Graphics g){
        drawSquares(g);
    }

    private void drawSquares(Graphics g) {
        for (Square square: squares) {

            g.fillRect((int)square.getHitbox().x, (int)square.getHitbox().y, SQUARE_WIDTH, SQUARE_HEIGHT);
            square.drawHitbox(g);
        }
    }
}
