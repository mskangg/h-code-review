import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_거리() {
        Car car1 = new Car();
        assertThat(car1.getDistance()).isEqualTo(0);
    }




}
