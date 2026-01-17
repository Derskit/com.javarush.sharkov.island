package enums;

import util.Random;

public enum Direction {
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1),
    LEFT_UP(-1, -1);

    public final int dirX;
    public final int dirY;

    private static final Direction[] VALUES = values();

    Direction(int directionX, int directionY) {
        this.dirX = directionX;
        this.dirY = directionY;
    }

    public static Direction rnd(){
        return VALUES[Random.getRandom(VALUES.length)];
    }
}
