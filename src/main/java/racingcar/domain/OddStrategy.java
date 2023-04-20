package racingcar.domain;

public class OddStrategy implements MoveStrategy {

    private static final int DEFAULT_INCREMENT = 1;
    private final int increment;

    public OddStrategy() {
        this(DEFAULT_INCREMENT);
    }

    public OddStrategy(int increment) {
        this.increment = increment;
    }



    @Override
    public int increment() {
        return increment;
    }

    @Override
    public boolean canMove(int number) {
        return number % 2 == 1;
    }
}
