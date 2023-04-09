import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingGame {

    private static final String MOVEMENT_PRINT_CHARACTER = "-";
    private static final String PRINT_LINE = "\n";

    private final List<Car> racingCar;
    private final int tryCount;
    private final StringBuilder racingResult = new StringBuilder();

    private CarRacingGame(List<Car> racingCar, int tryCount) {
        this.racingCar = racingCar;
        this.tryCount = tryCount;
    }

    public static CarRacingGame createRacing(int carCount, int tryCount) {
        return new CarRacingGame(generateRacingCars(carCount), tryCount);
    }

    public void startRacing() {
        IntStream.range(0, tryCount).forEach(count -> {
            racingCar.forEach(car -> {
                if (CarMovementCalculator.isCarMovement()) {
                    car.incrementMovement();
                }
                racingResult
                        .append(convertCarMovementToString(car.getMovement()))
                        .append(PRINT_LINE);
            });
            racingResult.append(PRINT_LINE);
        });
    }

    public String getRacingResult() {
        return racingResult.toString();
    }

    private static List<Car> generateRacingCars(int carCount) {
        return IntStream.range(0, carCount)
                .mapToObj(i -> Car.getInstance())
                .collect(Collectors.toList());
    }

    private static String convertCarMovementToString(int movement) {
        return MOVEMENT_PRINT_CHARACTER.repeat(Math.max(0, movement));
    }

}
