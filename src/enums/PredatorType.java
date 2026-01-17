package enums;


import java.util.Random;

public enum PredatorType {
    WOLF,
    BOA_CONSTRICTOR,
    FOX,
    BEAR,
    EAGLE;
    private static final Random random = new Random();

    public static PredatorType randomPredatorType() {
        return values()[random.nextInt(values().length)];
    }
}
