package controller;

import domain.CarRacingGame;
import view.request.CarRacingGameRequest;
import view.request.ConsoleRequest;
import view.result.ConsoleResponse;

public class CarRacingController {

    private final ConsoleRequest request;
    private final ConsoleResponse response;

    public CarRacingController(ConsoleRequest request, ConsoleResponse response) {
        this.request = request;
        this.response = response;
    }

    public void run() {
        request.prompt();
        CarRacingGameRequest.GameInput gameInput = (CarRacingGameRequest.GameInput) request.retrieve();

        CarRacingGame carRacingGame = CarRacingGame.createRacing(gameInput.getCarCount(), gameInput.getTotalLapCount());
        carRacingGame.racing();

        // FIXME raw 타입으로 되어있음
        response.print(carRacingGame.getRacingReport());
    }

}
