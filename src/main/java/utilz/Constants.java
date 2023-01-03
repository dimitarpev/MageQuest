package utilz;

import main.Game;

public class Constants {

    public static class EnemyConstants {
        public static final int SQUARE_WIDTH_DEFAULT = 64;
        public static final int SQUARE_HEIGHT_DEFAULT = 64;

        public static final int SQUARE_WIDTH = (int) (SQUARE_WIDTH_DEFAULT * Game.SCALE);
        public static final int SQUARE_HEIGHT = (int) (SQUARE_HEIGHT_DEFAULT * Game.SCALE);
    }
    public static class  Directions{
        public static final int UP = 0;
        public static final int DOWN = 1;
    }
    //directions, player constants....


}
