public class CarRacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = InputView.createInputView();
        CarRacingGame carRacingGame = CarRacingGame.createRacing(inputView.getCarCount(), inputView.getTryCount());
        carRacingGame.startRacing();
        ResultView.printResult(carRacingGame.getRacingResult());
    }

}
