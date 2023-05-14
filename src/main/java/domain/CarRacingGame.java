package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingGame {

    private final List<Car> racingCar;
    private final RacingReport racingReport;
    private int totalLapCount;

    private CarRacingGame(List<Car> racingCar, int totalLapCount) {
        this.racingCar = racingCar;
        this.totalLapCount = totalLapCount;
        this.racingReport = new RacingReport();
    }

    public static CarRacingGame createRacing(int carCount, int tryCount) {
        return new CarRacingGame(generateRacingCars(carCount), tryCount);
    }

    public void racing() {
        while (totalLapCount-- > 0) {
            moveCar();
            racingReport.put(totalLapCount, clone(racingCar));
            racing();
        }
    }

    public RacingReport getRacingReport() {
        return racingReport;
    }

    private void moveCar() {
        for (Car car : racingCar) {
            car.incrementMovement();
        }
    }

    private static List<Car> generateRacingCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> Car.getInstance())
                .collect(Collectors.toList());
    }

    private static List<Car> clone(List<Car> racingCar) {
        return racingCar.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }

    public static class RacingReport {
        private final Map<Integer, List<Car>> result = new LinkedHashMap<>();

        public void put(int gameLapCount, List<Car> racingCar) {
            result.put(gameLapCount, racingCar);
        }

        public Map<Integer, List<Car>> getResult() {
            return Collections.unmodifiableMap(result);
        }
    }
}
