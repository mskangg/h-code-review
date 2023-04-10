import java.util.Scanner;

public class InputView {

    public static RacingGame newGameByInput() {
        InputData inputData = getInput();
        return new RacingGame(inputData.getCarCount(), inputData.getMoveCount());
    }

    private static InputData getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCount = scanner.nextInt();

        return new InputData(carCount, moveCount);
    }

    private static class InputData {
        private final int carCount;
        private final int moveCount;

        public InputData(int carCount, int moveCount) {
            this.carCount = carCount;
            this.moveCount = moveCount;
        }

        public int getCarCount() {
            return carCount;
        }

        public int getMoveCount() {
            return moveCount;
        }
    }
}
