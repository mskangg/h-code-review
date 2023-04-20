package racingcar.domain;

public class ThresholdStrategy implements MoveStrategy {

    private static final int DEFAULT_THRESHOLD = 4;
    private final int threshold;

    public ThresholdStrategy() {
        this(DEFAULT_THRESHOLD);
    }

    public ThresholdStrategy(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean canMove(int number) {
        return number >= threshold;
    }
}
