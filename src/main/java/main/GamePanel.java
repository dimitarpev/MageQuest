package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;
    private MouseInputs mouseInputs;

    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1920, 696);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }

    //Paints everything on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

}
