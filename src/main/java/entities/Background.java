package entities;

import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Background extends Entity{

    private BufferedImage img;
    public Background(float x, float y, int height, int width) {
        super(x, y, height, width);

        importImg();
    }

    private void importImg() {
//        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.BACKGROUND_IMAGE);
        InputStream is = getClass().getResourceAsStream("/vecteezy_alien-planet-game-background_6316482_608/vecteezy_alien-planet-game-background_6316482.jpg");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void render(Graphics g) {
        g.drawImage(img, (int)x, (int)y, width, height, null);
    }

}
