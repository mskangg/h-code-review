import java.util.Scanner;

public class InputView {

    private final Input input;

    private InputView(Input input) {
        this.input = input;
    }

    public static InputView createInputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return new InputView(new Input(carCount, tryCount));
    }

    public int getCarCount() {
        return input.getCarCount();
    }

    public int getTotalLapCount() {
        return input.getTotalLapCount();
    }

    private static class Input {
        private final int carCount;
        private final int totalLapCount;

        private Input(int carCount, int totalLapCount) {
            this.carCount = carCount;
            this.totalLapCount = totalLapCount;
        }

        private int getCarCount() {
            return carCount;
        }

        private int getTotalLapCount() {
            return totalLapCount;
        }
    }

}
