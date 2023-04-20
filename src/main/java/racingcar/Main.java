package racingcar;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new ResultView());
        controller.run();
    }
}
