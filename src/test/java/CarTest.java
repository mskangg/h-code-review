import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @DisplayName("만들기만한 차는 움직이지 않는다.")
    @Test
    void test_justGetInstance_thenMovementZero() {
        Car car = Car.getInstance();
        assertEquals(0, car.getMovement());
    }

    @ParameterizedTest(name = "{index}번째 자동차는 {0}번 움직어야 한다.")
    @CsvSource({"1", "10", "5", "0", "7"})
    void test_incrementMovement(int movement) {
        Car car = Car.getInstance();

        for (int i = 0; i < movement; i++) {
            car.incrementMovement();
        }
        assertEquals(movement, car.getMovement());
    }

}