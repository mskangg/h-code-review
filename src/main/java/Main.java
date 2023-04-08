public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = InputView.newGameByInput();
        racingGame.run();
        ResultView.print(racingGame);
    }
}
