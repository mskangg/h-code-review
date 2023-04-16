package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = InputView.newGameByInput();
        racingGame.run();
        ResultView.print(racingGame);
    }
}
