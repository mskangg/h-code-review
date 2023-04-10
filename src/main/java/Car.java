import exception.NameLengthException;

public class Car {

    private final static String DISTANCE_CHARACTER = "-";
    private final static int THRESHOLD = 4;
    private final static int INITIAL_DISTANCE = 0;
    private final static String DEFAULT_NAME = "기본이름";
    private final static int NAME_MAX_LEN = 5;
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
            throw new NameLengthException();
        }
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            distance++;
        }
    }

    public String getDistString() {
        return DISTANCE_CHARACTER.repeat(distance);
    }

    public String getName() {
        return this.name;
    }

    public void moveRandomly() {
        move(random.getNumber());
    }
}
