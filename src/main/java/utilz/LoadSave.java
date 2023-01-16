package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    //public static final String IDLE_PLAYER_ATLAS = "wizard/idleSprite.png";
    public static final String IDLE_PLAYER_ATLAS = "wizard/idleTest.png";
    public static final String WALK_PLAYER_ATLAS = "wizard/walkSprite.png";

    public static final String PLAYER_ATLAS = "wizard/wizard_sprite.png";
    public static final String BACKGROUND_IMAGE = "vecteezy_alien-planet-game-background_6316482_608/vecteezy_alien-planet-game-background_6316482.jpg";
    public static final String MANABALL_1 = "Explosion_5/Explosion_1.png";
    public static final String MANABALL_2 = "Explosion_5/Explosion_2.png";

    public static final String ENEMY_BAT = "enemies/bat.png";
    public static final String ENEMY_BEE = "enemies/bee.png";
    public static final String ENEMY_BLUE = "enemies/blue.png";
    public static final String ENEMY_GREEN = "enemies/green.png";
    public static final String ENEMY_GREY = "enemies/grey.png";
    public static final String ENEMY_PINK = "enemies/pink.png";
    public static final String ENEMY_RED = "enemies/red.png";
    public static final String ENEMY_ROBOT = "enemies/robot.png";
    public static final String ENEMY_YELLOW = "enemies/yellow.png";
    public static final String ENEMY_ORANGE = "enemies/orange.png";
    public static final String ENEMY_SHOT = "enemies/enemyShot.png";


    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);

        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return img;
    }
}
