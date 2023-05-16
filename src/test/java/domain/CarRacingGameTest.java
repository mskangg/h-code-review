package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRacingGameTest {

    @DisplayName("실행하지 않은 레이싱의 결과는 비어있어야 한다.")
    @Test
    void test_justCreateRacing_thenRacingResultIsEmpty() {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(3, 5);
        assertEquals(0, carRacingGame.getRacingReport().getResult().size());
    }

    @DisplayName("레이싱을 수행한 차량이 0인 경우 레이싱의 결과가 비어있다.")
    @Test
    void test_carCountIsZero_thenRacingResultNotContainDash() {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(0, 10);
        carRacingGame.racing();
        assertEquals(10, carRacingGame.getRacingReport().getResult().size());
        carRacingGame.getRacingReport().getResult().values()
                .forEach(cars -> assertEquals(0, cars.size()));
    }

    @DisplayName("레이싱을 수행한 횟수가 0인 경우 레이싱의 결과가 비어있다.")
    @Test
    void test_tryCountIsZero_thenRacingResultNotContainDash() {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(10, 0);
        carRacingGame.racing();
        assertEquals(0, carRacingGame.getRacingReport().getResult().size());
    }

    @ParameterizedTest(name = "{index}번째 레이싱 결과와 상관 없이 {0} 번의 경기 결과가 있어야한다.")
    @CsvSource({
            "3",
            "5",
            "10"
    })
    void test_startRacing_thenHasGameCount(int totalLapCount) {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(3, totalLapCount);
        carRacingGame.racing();
        assertEquals(totalLapCount,
                carRacingGame.getRacingReport().getResult().size());
    }

    @ParameterizedTest(name = "{index}번째 레이싱 결과와 상관 없이 경기 마다 {0}개의 레이싱 차가 있어야한다.")
    @CsvSource({
            "4",
            "8",
            "9"
    })
    void test_startRacing_thenHasRacingCarCount(int carCount) {
        CarRacingGame carRacingGame = CarRacingGame.createRacing(carCount, 5);
        carRacingGame.racing();
        carRacingGame.getRacingReport().getResult().values()
                .forEach(cars -> assertEquals(carCount, cars.size()));
    }
}