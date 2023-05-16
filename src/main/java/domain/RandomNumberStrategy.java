package domain;

import java.util.Random;

public interface RandomNumberStrategy {
    int generate(int bound);
}

class DefaultRandomNumberStrategy implements RandomNumberStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public int generate(int bound) {
        return RANDOM.nextInt(bound + 1);
    }
}