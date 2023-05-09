package racingcar;

import racingcar.controller.Controller;
import racingcar.view.ConsoleInputView;
import racingcar.view.ConsoleResultView;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleInputView(), new ConsoleResultView());
        controller.run();
    }
}
