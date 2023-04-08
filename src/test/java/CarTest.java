import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
    public void 자동차_거리_출력() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Car car1 = new Car();
        car1.move(5);
        car1.move(9);
        car1.print();
        assertThat(out.toString().trim()).isEqualTo("--");

    }
}
