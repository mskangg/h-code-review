import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.ConstantGenerator;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    @ParameterizedTest
    @CsvSource({"2,5", "4,3"})
    public void 출력줄수_검증(int carCount, int moveCount) {

        RacingGame racingGame = RacingGame.withRandomMoving(carCount, moveCount);
        racingGame.run();
        assertThat(racingGame.getRecord()).hasLineCount((carCount + 1) * moveCount);
    }

    @Test
    public void 전진하는_자동차_출력에_이름을_같이_출력한다() {
        RacingGame racingGame = RacingGame.withRandomMoving(1, List.of("G80", "G90"));
        racingGame.run();
        assertThat(racingGame.getRecord())
                .contains("G80 : ")
                .contains("G90 : ");
    }

    @Test
    public void 누가_우승했는지를_알려준다() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of("G70", ConstantGenerator.of(3)));
        cars.add(Car.of("G90", ConstantGenerator.of(9)));
        RacingGame racingGame = new RacingGame(3, cars);
        racingGame.run();
        assertThat(racingGame.findWinners().toNames())
                .contains("G90")
                .hasSize(1);
    }
}
