public class Car {

    private static final int MAX_BOUND = 9;
    public static final int MOVABLE_THRESHOLD = 4;

    private int movement;
    private final RandomUtil randomUtil;

    public Car(int movement, RandomUtil randomUtil) {
        this.movement = movement;
        this.randomUtil = randomUtil;
    }

    public static Car getInstance() {
        return new Car(0, new DefaultRandomUtil());
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
        return MOVABLE_THRESHOLD < randomUtil.generate(MAX_BOUND);
    }

}
