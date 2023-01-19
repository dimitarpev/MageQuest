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

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int WALK = 1;
        public static final int RUNNING = 2;
        public static final int JUMP = 3;
        public static final int ATTACK = 4;
        public static final int HURT = 5;
        public static final int DIE = 6;
    }
    //directions, player constants....


}
