package utilz;

import main.Game;

public class Constants {
    //ALL GLOABL FINAL CONSTANTS USED IN THE GAME
    public static class UI{
        public static class Buttons{
            public static final int B_WITH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WITH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
        }
    }

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
