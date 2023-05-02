package view.result;

import domain.Car;
import domain.CarRacingGame;

import java.util.List;
import java.util.Map;

public class CarRacingGameResponse implements ConsoleResponse<CarRacingGame.RacingReport> {

    private static final String PRINT_LINE = "\n";
    private static final String MOVEMENT_PRINT_CHARACTER = "-";

    private final StringBuilder resultBuilder = new StringBuilder();

    @Override
    public void print(CarRacingGame.RacingReport racingReport) {
        makeResult(racingReport);
        System.out.println("실행 결과");
        System.out.println(resultBuilder);
        resultBuilder.setLength(0);
    }

    private void makeResult(CarRacingGame.RacingReport racingReport) {
        Map<Integer, List<Car>> result = racingReport.getResult();
        for (List<Car> racingCar : result.values()) {
            appendResult(racingCar);
        }
    }

    private void appendResult(List<Car> racingCar) {
        for (Car car : racingCar) {
            resultBuilder
                    .append(getMovementToString(car.getMovement()))
                    .append(PRINT_LINE);
        }
        resultBuilder
                .append(PRINT_LINE);
    }

    private static String getMovementToString(int movement) {
        return MOVEMENT_PRINT_CHARACTER.repeat(Math.max(0, movement));
    }

}
