import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource({"2,5", "4,3"})
    public void 출력줄수_검증(int carCount, int moveCount) {

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        racingGame.run();
        assertThat(racingGame.getRecord()).hasLineCount((carCount + 1) * moveCount);
    }

    @Test
    public void 출력에_이름포함() {
        RacingGame racingGame = new RacingGame(1, "G80", "G90");
        racingGame.run();
        assertThat(racingGame.getRecord())
                .contains("G80 : ")
                .contains("G90 : ");
    }

    @Test
    public void 우승자_반환() {
        RacingGame racingGame = new RacingGame(5, "G70", "G80", "G90");
        racingGame.run();
        assertThat(racingGame.getWinners()).isNotEmpty();
    }
}
