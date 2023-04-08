import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_거리() {
        Car car1 = new Car();
        assertThat(car1.getDistance()).isEqualTo(0);
    }

    @Test
    public void 자동차_전진() {
        Car car1 = new Car();
        car1.move(4);
        assertThat(car1.getDistance()).isEqualTo(1);
        car1.move(9);
        assertThat(car1.getDistance()).isEqualTo(2);
    }
}
