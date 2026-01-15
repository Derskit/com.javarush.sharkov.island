package util;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static int getRandom(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}
