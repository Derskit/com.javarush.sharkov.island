package entity.herbivore;

import java.util.Random;

public enum HerbivoreType {
    HORSE,
    DEER,
    RABBIT,
    MOUSE,
    GOAT,
    SHEEP,
    WILD_BOAR,
    BUFFALO,
    DUCK,
    CATERPILLAR;
    private static final Random random = new Random();
    public static HerbivoreType randomHerbivoreType(){
        return values()[random.nextInt(values().length)];
    }
}
