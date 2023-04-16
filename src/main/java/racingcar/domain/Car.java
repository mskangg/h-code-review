package racingcar.domain;

import racingcar.exception.NameLengthException;

public class Car implements Comparable<Car> {

    public final static String DEFAULT_NAME = "기본이름";
    public final static int NAME_MAX_LEN = 5;
    private final static int THRESHOLD = 4;
    private final static int INITIAL_DISTANCE = 0;
    private final Random random;
    private final String name;
    private int distance;

    public Car() {
        this(DEFAULT_NAME);
    }

    public Car(String name) {
        validName(name);
        this.name = name;
        this.distance = INITIAL_DISTANCE;
        this.random = new Random();
    }

    private static void validName(String name) {
        if (name.length() > NAME_MAX_LEN) {
            throw new NameLengthException(name);
        }
    }

    public void move(int number) {
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

    public void moveRandomly() {
        move(random.getNumber());
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.distance, o.distance);
    }
}
