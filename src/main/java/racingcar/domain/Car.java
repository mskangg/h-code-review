package racingcar.domain;

import racingcar.exception.NameLengthException;

public class Car implements Comparable<Car> {

    public final static String DEFAULT_NAME = "기본이름";
    public final static int NAME_MAX_LEN = 5;
    private final static int THRESHOLD = 4;
    private final static int INITIAL_DISTANCE = 0;
    private final NumberGenerator numberGenerator;
    private final String name;
    private int distance;

    private Car(NumberGenerator numberGenerator, String name, int distance) {
        validName(name);

        this.numberGenerator = numberGenerator;
        this.name = name;
        this.distance = distance;
    }

    public Car() {
        this(RandomGenerator.getInstance(), DEFAULT_NAME, INITIAL_DISTANCE);
    }

    public static Car of(String name, NumberGenerator numberGenerator) {
        return new Car(numberGenerator, name, INITIAL_DISTANCE);
    }

    private static void validName(String name) {
        if (name.length() > NAME_MAX_LEN) {
            throw new NameLengthException(name);
        }
    }

    private void pMove(int number) {
        if (number >= THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        pMove(numberGenerator.getNumber());
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }

    public boolean isMax(Car maxCar) {
        return this.compareTo(maxCar) == 0;
    }
}
