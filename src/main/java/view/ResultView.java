package view;

import java.util.List;

public class ResultView {

    private static final String PRINT_LINE = "\n";

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

    public void appendResult(List<ResultCar> racingCar) {
        for (ResultCar resultCar : racingCar) {
            resultBuilder
                    .append(resultCar.getMovementToString())
                    .append(PRINT_LINE);
        }
        resultBuilder
                .append(PRINT_LINE);
    }

}
