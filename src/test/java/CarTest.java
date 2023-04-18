import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @DisplayName("만들기만한 차는 움직이지 않는다.")
    @Test
    void test_justGetInstance_thenMovementZero() {
        Car car = Car.getInstance();
        assertEquals(0, car.getMovement());
    }

    @ParameterizedTest(name = "{index}번째 자동차는 {0}번 이동 한다. (단, 랜덤은 동작하지 않는다.)")
    @CsvSource({"1", "10", "5", "0", "7"})
    void test_boundNotRandom_thenAlwaysIncrementMovement(int movement) {
        // 항상 이동하도록 강제 지정한다.
        RandomNumberStrategy randomNumberStrategy = bound -> Car.MOVABLE_THRESHOLD + 1;
        Car car = new Car(0, randomNumberStrategy);

        for (int i = 0; i < movement; i++) {
            car.incrementMovement();
        }
        assertEquals(movement, car.getMovement());
    }

    @ParameterizedTest(name = "{index}번째 자동차는 {0}번 보다 이동하지 않는다.")
    @CsvSource({"3", "9", "12"})
    void test_boundRandom_thenNotGreaterThenMovementPlusOne(int movement) {
        Car car = Car.getInstance();

        for (int i = 0; i < movement; i++) {
            car.incrementMovement();
        }
        assertTrue(movement + 1 > car.getMovement());
    }

}