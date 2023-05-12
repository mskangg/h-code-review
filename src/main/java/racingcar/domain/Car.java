package racingcar.domain;

import racingcar.exception.NameLengthException;

public class Car implements Comparable<Car> {

    public final static String DEFAULT_NAME = "기본이름";
    public final static int NAME_MAX_LEN = 5;
    private final static int INITIAL_DISTANCE = 0;
    private final NumberGenerator numberGenerator;
    private final MoveStrategy moveStrategy;
    private final String name;
    private int distance;

    private Car(NumberGenerator numberGenerator, MoveStrategy moveStrategy, String name, int distance) {
        validName(name);

        this.numberGenerator = numberGenerator;
        this.moveStrategy = moveStrategy;
        this.name = name;
        this.distance = distance;
    }

    public Car() {
        this(RandomGenerator.getInstance(), new ThresholdStrategy(), DEFAULT_NAME, INITIAL_DISTANCE);
    }

    public Car(String name, NumberGenerator numberGenerator) {
        this(numberGenerator, new ThresholdStrategy(), name, INITIAL_DISTANCE);
    }

    public Car(NumberGenerator numberGenerator) {
        this(numberGenerator, new ThresholdStrategy(), DEFAULT_NAME, INITIAL_DISTANCE);
    }

    public Car(NumberGenerator numberGenerator, MoveStrategy moveStrategy) {
        this(numberGenerator, moveStrategy, DEFAULT_NAME, INITIAL_DISTANCE);
    }

    private static void validName(String name) {
        if (name.length() > NAME_MAX_LEN) {
            throw new NameLengthException(name);
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        if (moveStrategy.canMove(numberGenerator.getNumber())) {
            distance += moveStrategy.increment();
        }
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    public boolean isMax(Car maxCar) {
        return this.compareTo(maxCar) == 0;
    }
}
