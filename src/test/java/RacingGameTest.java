import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource({"2,5", "4,3"})
    public void 출력줄수_검증(int carCount, int moveCount) {

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        racingGame.run();
        assertThat(racingGame.getRecord()).hasLineCount((carCount+1)*moveCount);
    }
}
