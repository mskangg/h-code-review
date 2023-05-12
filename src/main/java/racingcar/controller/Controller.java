package racingcar.controller;

import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.view.InputData;
import racingcar.view.Request;
import racingcar.view.Response;

public class Controller {

    private final Request request;
    private final Response response;

    public Controller(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public void run() {
        InputData inputData = request.getInput();

        RacingGame racingGame = inputData.toRacingGame();
        GameResult gameResult = racingGame.run();

        response.print(gameResult);
    }
}
