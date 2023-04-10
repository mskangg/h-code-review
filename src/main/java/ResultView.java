public class ResultView {

    private static final String FIRST_LINE = "\n실행 결과";

    public static void print(RacingGame racingGame) {
        System.out.println(FIRST_LINE);
        System.out.print(racingGame.getRecord());
    }
}
