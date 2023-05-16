package view.request;

import java.util.Scanner;

public class CarRacingGameRequest {

    private GameInput gameInput;

    public void prompt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        gameInput = new GameInput(carCount, tryCount);
    }
    
    public GameInput retrieve() {
        return gameInput;
    }

    public static class GameInput {
        private final int carCount;
        private final int totalLapCount;

        private GameInput(int carCount, int totalLapCount) {
            this.carCount = carCount;
            this.totalLapCount = totalLapCount;
        }

        public int getCarCount() {
            return carCount;
        }

        public int getTotalLapCount() {
            return totalLapCount;
        }
    }
}
