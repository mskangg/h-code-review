package racingcar.domain;

public class ThresholdStrategy implements MoveStrategy {

    private static final int DEFAULT_THRESHOLD = 4;
    private static final int DEFAULT_INCREMENT = 1;
    private final int threshold;
    private final int increment;

    public ThresholdStrategy() {
        this(DEFAULT_THRESHOLD, DEFAULT_INCREMENT);
    }

    public ThresholdStrategy(int threshold, int increment) {
        this.threshold = threshold;
        this.increment = increment;
    }

    @Override
    public int increment() {
        return increment;
    }

    @Override
    public boolean canMove(int number) {
        return number >= threshold;
    }
}
