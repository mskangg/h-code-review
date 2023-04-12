package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    public static final char NEW_LINE = '\n';
    public static final String DELIMITER = " : ";
    public static final String DISTANCE_CHARACTER = "-";
    private final List<Car> cars;
    private final StringBuilder gameRecord;
    private int remainingMoves;

    public RacingGame(int carCount, int remainingMoves) {
        this(remainingMoves, Collections.nCopies(carCount, Car.DEFAULT_NAME));
    }

    public RacingGame(int remainingMoves, String... names) {
        this(remainingMoves, List.of(names));
    }

    public RacingGame(int remainingMoves, List<String> names) {
        this.remainingMoves = remainingMoves;
        this.gameRecord = new StringBuilder();

        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
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

    public Winners findWinners() {
        return new Winners(cars);
    }

    private void record() {
        for (Car car : cars) {
            gameRecord.append(car.getName())
                    .append(DELIMITER)
                    .append(DISTANCE_CHARACTER.repeat(car.getDistance()))
                    .append(NEW_LINE);
        }
        gameRecord.append(NEW_LINE);
    }
}
