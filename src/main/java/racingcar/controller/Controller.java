package racingcar.controller;

import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.view.Request;
import racingcar.view.Response;

public class Controller {

    private Request request;
    private Response response;

    public Controller(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public void run() {
        RacingGame racingGame = request.newGame();
        GameResult gameResult = racingGame.run();
        response.print(gameResult);
    }
}
