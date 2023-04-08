public class Car {

    private final static String DISTANCE_CHARACTER = "-";
    private final static int THRESHOLD = 4;
    private final static int INITIAL_DISTANCE = 0;
    private final Random random;
    private int distance;

    public Car() {
        distance = INITIAL_DISTANCE;
        random = new Random();
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            distance++;
        }
    }

    public String getDistString() {
        return DISTANCE_CHARACTER.repeat(distance);
    }

    public void moveRandomly() {
        move(random.getNumber());
    }
}
