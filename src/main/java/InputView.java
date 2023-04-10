import java.util.List;
import java.util.Scanner;

public class InputView {

    public static RacingGame newGameByInput() {
        InputData inputData = getInput();
        return new RacingGame(inputData.getMoveCount(), inputData.getNames());
    }

    private static InputData getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = List.of(scanner.nextLine().split(","));

        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return new InputData(moveCount, names);
    }

    private static class InputData {

        private final int moveCount;
        private final List<String> names;

        public InputData(int moveCount, List<String> names) {
            this.moveCount = moveCount;
            this.names = names;
        }

        public int getMoveCount() {
            return moveCount;
        }

        public List<String> getNames() {
            return names;
        }
    }
}
