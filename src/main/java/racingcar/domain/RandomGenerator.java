package racingcar.domain;

import java.util.Random;

public class RandomGenerator implements NumberGenerator{

    private final static int MAX = 9;
    private final java.util.Random random = new Random();
    private static final RandomGenerator instance = new RandomGenerator();

    private RandomGenerator() {
    }

    public static RandomGenerator getInstance() {
        return instance;
    }

    public int getNumber() {
        return random.nextInt(MAX+1);
    }
}
