package racingcar.view;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import racingcar.domain.GameResult;

public class ConsoleResultView implements Response {

    public static final char NEW_LINE = '\n';
    public static final String DELIMITER = " : ";
    public static final String DISTANCE_CHARACTER = "-";
    private static final String FIRST_LINE = "\n실행 결과";
    private static final String LAST_LINE = "가 최종 우승했습니다.";
    public static final String COMMA = ", ";

    public void print(GameResult gameResult) {
        System.out.println(FIRST_LINE);
        while (isRemain(gameResult)) {
            printRounds(gameResult);
        }
        System.out.print(String.join(COMMA, gameResult.getWinners().toNames()));
        System.out.println(LAST_LINE);
    }

    private void printRounds(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, LinkedList<Integer>> roundResults = gameResult.getRoundResults();
        for (String name : roundResults.keySet()) {
            LinkedList<Integer> record = roundResults.get(name);
            stringBuilder.append(name)
                    .append(DELIMITER)
                    .append(DISTANCE_CHARACTER.repeat(record.pollFirst()))
                    .append(NEW_LINE);
        }
        stringBuilder.append(NEW_LINE);
        System.out.print(stringBuilder);
    }

    private boolean isRemain(GameResult gameResult) {
        Collection<LinkedList<Integer>> records = gameResult.getRoundResults().values();
        List<Integer> record = records.stream().findFirst().get();
        return !record.isEmpty();
    }


}
