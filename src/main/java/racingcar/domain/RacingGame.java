package racingcar.domain;

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

    public static RacingGame withRandomMoving(int carCount, int remainingMoves) {
        return withRandomMoving(remainingMoves, Collections.nCopies(carCount, Car.DEFAULT_NAME));
    }

    public static RacingGame withRandomMoving(int remainingMoves, List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, RandomGenerator.getInstance()));
        }
        return new RacingGame(remainingMoves, cars);
    }

    public RacingGame (int remainingMoves, List<Car> cars) {
        this.remainingMoves = remainingMoves;
        this.gameRecord = new StringBuilder();
        this.cars = cars;
    }


    public String getRecord() {
        return gameRecord.toString();
    }

    public void move() {
        for (Car car : cars) {
            car.move();
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
