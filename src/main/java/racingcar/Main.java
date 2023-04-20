package racingcar;

import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = InputView.newGameByInput();
        GameResult gameResult = racingGame.run();
        ResultView.print(gameResult);
    }
}
