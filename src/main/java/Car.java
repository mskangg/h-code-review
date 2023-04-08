public class Car {

    private final static String DISTANCE_CHARACTER = "-";
    private final static int THRESHOLD = 4;
    private final static int INITIAL_DISTANCE = 0;
    private int distance;

    public Car() {
        distance = INITIAL_DISTANCE;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            distance++;
        }
    }

    public void print() {
        System.out.println(DISTANCE_CHARACTER.repeat(distance));
    }
}
