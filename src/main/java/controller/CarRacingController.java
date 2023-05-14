package controller;

import domain.CarRacingGame;
import view.request.CarRacingGameRequest;
import view.result.CarRacingGameResponse;

public class CarRacingController {

    private final CarRacingGameRequest request;
    private final CarRacingGameResponse response;

    public CarRacingController(CarRacingGameRequest request, CarRacingGameResponse response) {
        this.request = request;
        this.response = response;
    }

    public void run() {
        request.prompt();
        CarRacingGameRequest.GameInput gameInput = request.retrieve();

        CarRacingGame carRacingGame = CarRacingGame.createRacing(gameInput.getCarCount(), gameInput.getTotalLapCount());
        carRacingGame.racing();
        
        response.print(carRacingGame.getRacingReport());
    }

}
