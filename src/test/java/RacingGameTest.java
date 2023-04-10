import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    public void 출력줄수_검증1() {
        int carCount = 2;
        int moveCount = 5;

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        racingGame.run();

        assertThat(racingGame.getRecord()).hasLineCount((carCount+1)*moveCount);
    }

    @Test
    public void 출력줄수_검증2() {
        int carCount = 4;
        int moveCount = 3;

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        racingGame.run();

        assertThat(racingGame.getRecord()).hasLineCount((carCount+1)*moveCount);
    }

}
