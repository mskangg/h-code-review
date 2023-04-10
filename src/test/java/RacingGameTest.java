import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.NameCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource({"2,5", "4,3"})
    public void 출력줄수_검증(int carCount, int moveCount) {

        RacingGame racingGame = new RacingGame(carCount, moveCount);
        racingGame.run();
        assertThat(racingGame.getRecord()).hasLineCount((carCount + 1) * moveCount);
    }

    @Test
    public void 레이싱결과_이름_출력() {
        RacingGame racingGame = new RacingGame(2, 1, "G80", "G90");
        racingGame.run();
        assertThat(racingGame.getRecord())
                .contains("G80 : ")
                .contains("G90 : ");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4})
    public void 레이싱게임객체_가변인자_예외(int carCount) {
        assertThrows(NameCountException.class, () ->
                new RacingGame(carCount, 1, "G70", "G80", "G90"));
    }
}
