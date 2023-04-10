import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.NameLengthException;
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

    @Test
    public void 자동차_멈춤() {
        Car car1 = new Car();
        car1.move(0);
        car1.move(1);

        assertThat(car1.getDistance()).isEqualTo(0);
    }

    @Test
    public void 자동차_이름부여() {
        String name = "GV70";
        Car car1 = new Car(name);
        assertThat(car1.getName()).isEqualTo(name);
    }

    @Test
    public void 자동차_이름길이예외() {
        String name = "123456";
        assertThrows(NameLengthException.class, () -> {
            new Car(name);
        });
    }

}
