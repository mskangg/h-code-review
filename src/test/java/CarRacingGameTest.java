import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRacingGameTest {

    @DisplayName("실행하지 않은 레이싱의 결과는 비어있어야 한다.")
    @Test
    void test_justCreateRacing_thenRacingResultIsEmpty() {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(3, 5);
        assertEquals("", carRacingGame.getRacingResult());
    }

    @DisplayName("레이싱을 수행한 차량이 0인 경우 레이싱의 결과에 - 를 포함하지 않아야 한다.")
    @Test
    void test_carCountIsZero_thenRacingResultNotContainDash() {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(0, 10);
        carRacingGame.startRacing();
        assertThat(carRacingGame.getRacingResult()).doesNotContain("-");
    }

    @DisplayName("레이싱을 수행한 횟수가 0인 경우 레이싱의 결과에 - 를 포함하지 않아야 한다.")
    @Test
    void test_tryCountIsZero_thenRacingResultNotContainDash() {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(10, 0);
        carRacingGame.startRacing();
        assertThat(carRacingGame.getRacingResult()).doesNotContain("-");
    }

    @ParameterizedTest(name = "{index}번째 레이싱 결과와 상관 없이 ({0} + 1) x {1} 의 라인 결과를 반환해야한다.")
    @CsvSource({
            "3, 5",
            "5, 3",
            "10, 10"
    })
    void test_startRacing_thenHasLineCount(int carCount, int tryCount) {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(carCount, tryCount);
        carRacingGame.startRacing();
        assertThat(carRacingGame.getRacingResult()).hasLineCount((carCount + 1) * tryCount);
    }

}