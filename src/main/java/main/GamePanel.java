package main;

import entities.Player;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import utilz.LoadSave;
import  utilz.Constants.Directions.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {
    //PANEL OF THE GAME
    private Game game;
    private MouseInputs mouseInputs;
    private BufferedImage img;



    public GamePanel(Game game){
        mouseInputs = new MouseInputs(this);
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
//        importImg();
    }

    private void importImg() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND_IMAGE);

//        try{
//            img = ImageIO.read(is);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
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


        //g.drawImage(img, 0, 0, null);
        //g.drawImage(img, 0, 0, 1920, 696, null);
    }




    public Game getGame() {
        return game;
    }
}
