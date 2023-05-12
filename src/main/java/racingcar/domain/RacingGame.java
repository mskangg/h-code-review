package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final GameResult gameResult;
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
        this.gameResult = new GameResult();
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public GameResult run() {
        while (remainingMoves-- > 0) {
            move();
            gameResult.addRound(cars);
        }
        gameResult.setWinners(findWinners());
        return gameResult;
    }

    public Winners findWinners() {
        return new Winners(cars);
    }
}
