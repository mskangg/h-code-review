import domain.CarRacingGame;
import view.InputView;
import view.ResultView;

public class CarRacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = InputView.createInputView();
        CarRacingGame carRacingGame = CarRacingGame.createRacing(inputView.getCarCount(), inputView.getTotalLapCount());

        ResultView resultView = ResultView.createResultView();
        while (carRacingGame.isRacingContinue()) {
            resultView.appendResult(carRacingGame.racing());
        }
        resultView.printResult();
    }

}
