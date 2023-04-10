import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private static final String FIRST_LINE = "\n실행 결과";
    private static final String LAST_LINE = "가 최종 우승했습니다.";

    public static void print(RacingGame racingGame) {
        System.out.println(FIRST_LINE);
        System.out.print(racingGame.getRecord());
        printWinners(racingGame);
    }

    private static void printWinners(RacingGame racingGame) {
        System.out.print(String.join(", ", getWinnersNameList(racingGame)));
        System.out.println(LAST_LINE);
    }

    private static List<String> getWinnersNameList(RacingGame racingGame) {
        List<String> names = new ArrayList<>();
        for (Car winner : racingGame.getWinners()) {
            names.add(winner.getName());
        }
        return names;
    }
}
