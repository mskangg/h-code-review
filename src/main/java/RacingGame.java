import exception.NameCountException;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static final char NEW_LINE = '\n';
    public static final String DELIMITER = " : ";
    private final List<Car> cars;
    private final StringBuilder gameRecord;
    private int remainingMoves;

    public RacingGame(int carCount, int remainingMoves) {
        this.remainingMoves = remainingMoves;
        this.gameRecord = new StringBuilder();

        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public RacingGame(int carCount, int remainingMoves, String... names) {
        validNames(carCount, names);
        this.remainingMoves = remainingMoves;
        this.gameRecord = new StringBuilder();

        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(names[i]));
        }
    }

    private static void validNames(int carCount, String[] names) {
        if (names.length != carCount) {
            throw new NameCountException();
        }
    }


    public String getRecord() {
        return gameRecord.toString();
    }

    public void move() {
        for (Car car : cars) {
            car.moveRandomly();
        }
    }

    public void run() {
        while (remainingMoves-- > 0) {
            move();
            record();
        }
    }

    private void record() {
        for (Car car : cars) {
            gameRecord.append(car.getName())
                    .append(DELIMITER)
                    .append(car.getDistString())
                    .append(NEW_LINE);
        }
        gameRecord.append(NEW_LINE);
    }
}
