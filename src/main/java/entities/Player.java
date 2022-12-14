package entities;

import inputs.KeyboardInputs;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Player extends Entity{

    GamePanel Panel;
    KeyboardInputs Kbi;

private BufferedImage[][] animations;



    public Player(float x, float y , GamePanel panel , KeyboardInputs kbi) {

        super(x, y);

        this.Panel=Panel;
        this.Kbi=Kbi;
        setDefaultValues();
        getPlayerImage();
    }




    public void setDefaultValues() {
        x=100;
        y=100;
        //speed=?

    }


    public void getPlayerImage()
    {  /* try{
            upP = ImageIO.read(getClass().getResourceAsStream("1_RUN_004.png"));
            downP = ImageIO.read(getClass().getResourceAsStream("1_RUN_002.png"));
            leftP = ImageIO.read(getClass().getResourceAsStream("1_RUN_002.png"));
            rightP = ImageIO.read(getClass().getResourceAsStream("1_RUN_002.png"));

    }catch(IOException e){e.printStackTrace();}*/


       if (Kbi.upP=true){

          getClass().getResourceAsStream("1_RUN_004.png");
       }else getClass().getResourceAsStream("1_IDLE_000.png");

        if (Kbi.downP=true){
            getClass().getResourceAsStream("1_RUN_004.png");
        }else getClass().getResourceAsStream("1_IDLE_000.png");

    }

    public void update() {

        //character movement with grid jumps


    }


}

