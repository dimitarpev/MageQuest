package entities;

import gamestates.Playing;
import main.Game;
import utilz.LoadSave;
import  ui.GameOverOverlay;
import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.PlayerConstants.*;


public class Player extends Entity{
    //MAIN PLAYER CLASS
    private BufferedImage[][] animations;
    BufferedImage imgs;
    private int aniTick, aniIndex, aniSpeed = 50;

    public int livesOfPlayer = 3;
    private int playerAction = IDLE;
    private float xValue = x;
    private float yValue = y;
    private boolean moving = false;
    private boolean up, down;
    public boolean CANSHOOT = true;
    private Playing playing;
    private boolean gameOver;

    float ticker = 0f;
    int ticker2 = 0;
    private float playerSpeed = 2.0f;
    private float xDrawOffset = 24 * Game.SCALE;
    private float yDrawOffset = 20 * Game.SCALE;


    public Player(float x, float y , int width, int height, Playing playing) {

        super(x, y, width, height);
        this.playing = playing;
        loadAnimations();
        setDefaultValues();
        getPlayerImage();
        initHitbox(x, y + 10, 45 * Game.SCALE, 65 * Game.SCALE - 10);
    }




    //LOAD PLAYER ANIMATIONS FROM SPRITE (SPRITE CURRENTLY NOT PROPER)
    private void loadAnimations() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);


        animations = new BufferedImage[7][5];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length ; i++) {
                animations[j][i] = img.getSubimage(i*140, j*128, 130, 128);
            }
            //animations[i] = img.getSubimage(i*387, 0, 387, 350);
//            animations[i][j] = img.getSubimage(i*64, 0, 64, 58);
        }


    }


    public void setDefaultValues() {

        //speed=?

    }


    public void getPlayerImage()
    {


//       if (Kbi.upP=true){
//
//          getClass().getResourceAsStream("1_RUN_004.png");
//       }else getClass().getResourceAsStream("1_IDLE_000.png");
//
//        if (Kbi.downP=true){
//            getClass().getResourceAsStream("1_RUN_004.png");
//        }else getClass().getResourceAsStream("1_IDLE_000.png");

    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, width, height, null);
        drawHitbox(g);
    }



    private void updatePos() {
        //UPDATE POSITION (MOVING) OF THE PLAYER
        moving = false;

        if((up && !down) && y > 0){
            y -= playerSpeed;
            yValue -= playerSpeed;
            hitbox.y -= playerSpeed;
            moving = true;
        }
        else if ((!up && down) && y < 580) {
            y += playerSpeed;
            yValue += playerSpeed;
            hitbox.y += playerSpeed;
            moving = true;

        }

    }

    public void update() {
        //UPDATE WHOLE PLAYER AND ENDS GAME IF PLAYER DIES
        if(livesOfPlayer <= 0){
            playing.setGameOver(true);
            return;
        }

        updatePos();
        updateAnimationTick();
        setAnimation();
        //shotCooldown();

    }
//  TEST FOR PLAYER SHOT COOLDOWN FOR FUTURE USES
//    public void shotCooldown() {
//        if (!CANSHOOT) {
//            TimerTask repeatedTask = new TimerTask() {
//                public void run() {
//                    CANSHOOT = true;
//                }
//            };
//            Timer timer = new Timer("Timer");
//
//            long delay = 2000L;
//            long period = 2000L;
////            if (CANSHOOT)
////                timer.purge();
//
//            timer.scheduleAtFixedRate(repeatedTask, delay, period);
//
//        }
//    }

    //SET PLAYER'S ANIMATION DEPENDING ON THE ACTION (GET NUMBERS FROM CONSTANTS CLASS)
    private void setAnimation() {
        int startAni = playerAction;

        if(moving)
            playerAction = IDLE;
        else
            playerAction = IDLE;

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
//            if (!CANSHOOT){
//                shotCooldown();
//            }
//            if (!CANSHOOT) {
//                aniIndex = 0;
//            }
            //CURRENTLY USED ENEMY SHOT COOLDOWN METHOD (NOT FLEXIBLE AND WITH SOME SHOTS NOT DETECTING)
            ticker+= 0.5f;
            if (ticker == 1f) {
                CANSHOOT = true;
                ticker = 0;
            }
            if (aniIndex >= 4) {
                aniIndex = 0;
//                ticker++;
//                if (ticker == 1) {
//                    CANSHOOT = true;
//                    ticker = 0;
//                }
            }
        }
    }
    public void resetAll() {
        resetDirBoolean();
        moving = false;
        playerAction = IDLE;
        livesOfPlayer = 3;
        hitbox.x = x;
        hitbox.y = y;
    }

    public float getxValue() {
        return xValue;
    }

    public float getyValue(){
        return yValue;
    }

    public void resetDirBoolean(){
        up = false;
        down = false;
    }
    public int getLivesOfPlayer(){ return livesOfPlayer;}

    public void setLivesOfPlayer(int livesOfPlayer) {
        this.livesOfPlayer = livesOfPlayer;
    }
    public boolean isUp(){
        return up;
    }
    public void setUp(boolean up){
        this.up = up;
    }
    public boolean isDown(){
        return down;
    }
    public void setDown(boolean down){
        this.down = down;
    }

    public boolean getCANSHOOT() {
        return CANSHOOT;
    }

    public void setCANSHOOT(boolean canshoot) {
        this.CANSHOOT = canshoot;
    }

}


