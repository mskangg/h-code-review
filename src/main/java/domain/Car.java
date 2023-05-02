package domain;

public class Car implements Cloneable {

    private static final int MAX_BOUND = 9;
    public static final int MOVABLE_THRESHOLD = 4;

    private final RandomNumberStrategy randomNumberStrategy;
    private int movement;

    public Car(int movement, RandomNumberStrategy randomNumberStrategy) {
        this.movement = movement;
        this.randomNumberStrategy = randomNumberStrategy;
    }

    public static Car getInstance() {
        return new Car(0, new DefaultRandomNumberStrategy());
    }

    public void incrementMovement() {
        if (!isMovable()) {
            return;
        }
        movement++;
    }

    public int getMovement() {
        return movement;
    }

    private boolean isMovable() {
        return MOVABLE_THRESHOLD < randomNumberStrategy.generate(MAX_BOUND);
    }

    @Override
    protected Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
