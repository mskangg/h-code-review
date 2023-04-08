import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public static final char NEW_LINE = '\n';
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


    public String getRecord() {
        return gameRecord.toString();
    }

    public void move() {
        cars.forEach(Car::moveRandomly);
    }

    public void run() {
        while (remainingMoves-- > 0) {
            move();
            record();
        }
    }

    private void record() {
        for (Car car : cars) {
            gameRecord.append(car.getDistString());
            gameRecord.append(NEW_LINE);
        }
        gameRecord.append(NEW_LINE);
    }
}
