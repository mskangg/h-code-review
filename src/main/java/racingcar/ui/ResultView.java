package racingcar.ui;

import racingcar.RacingGame;

public class ResultView {

    private static final String FIRST_LINE = "\n실행 결과";
    private static final String LAST_LINE = "가 최종 우승했습니다.";

    public static void print(RacingGame racingGame) {
        printRecord(racingGame);
        printWinners(racingGame);
    }

    private static void printRecord(RacingGame racingGame) {
        System.out.println(FIRST_LINE);
        System.out.print(racingGame.getRecord());
    }

    private static void printWinners(RacingGame racingGame) {
        System.out.print(String.join(", ", racingGame.findWinners().toNames()));
        System.out.println(LAST_LINE);
    }
}
