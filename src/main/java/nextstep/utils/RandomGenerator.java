package nextstep.utils;

import java.util.Random;

public class RandomGenerator {

    private final static int MIN = 0;
    private final static int MAX = 9;
    private final static Random random = new Random();

    public static int create() {
        return random.nextInt(MAX + MIN) + MIN;
    }
}
