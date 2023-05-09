package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements Request {

    private static final Scanner scanner = new Scanner(System.in);

    public InputData getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = List.of(scanner.nextLine().split(","));

        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return new InputData(moveCount, names);
    }
}
