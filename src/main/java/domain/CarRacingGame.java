package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingGame {

    private final List<Car> racingCar;
    private final int totalLapCount;

    private int gameLapCount = 0;

    private CarRacingGame(List<Car> racingCar, int totalLapCount) {
        this.racingCar = racingCar;
        this.totalLapCount = totalLapCount;
    }

    public static CarRacingGame createRacing(int carCount, int tryCount) {
        return new CarRacingGame(generateRacingCars(carCount), tryCount);
    }

    public List<Car> racing() {
        if (!isRacingContinue()) {
            throw new RuntimeException("경주가 종료되었습니다");
        }

        gameLapCount++;
        for (Car car : racingCar) {
            car.incrementMovement();
        }
        return Collections.unmodifiableList(racingCar);
    }

    public boolean isRacingContinue() {
        return gameLapCount < totalLapCount;
    }

    private static List<Car> generateRacingCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> Car.getInstance())
                .collect(Collectors.toList());
    }

}
