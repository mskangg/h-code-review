package view;

import domain.Car;

import java.util.List;

public class ResultView {

    private static final String PRINT_LINE = "\n";
    private static final String MOVEMENT_PRINT_CHARACTER = "-";

    private final StringBuilder resultBuilder = new StringBuilder();

    private ResultView() {
    }

    public static ResultView createResultView() {
        return new ResultView();
    }

    public void printResult() {
        System.out.println("실행 결과");
        System.out.println(resultBuilder);
        resultBuilder.setLength(0);
    }

    public void appendResult(List<Car> racingCar) {
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
