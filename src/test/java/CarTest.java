import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import racingcar.domain.Car;
import racingcar.domain.ConstantGenerator;
import racingcar.domain.EvenStrategy;
import racingcar.domain.OddStrategy;
import racingcar.domain.RandomGenerator;
import racingcar.exception.NameLengthException;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 전진하는_조건은_0에서_9_사이에서_random_값을_구한_후_random_값이_4이상일_경우이다() {
        Car car1 = new Car(ConstantGenerator.of(3));
        Car car2 = new Car(ConstantGenerator.of(5));
        car1.move();
        car2.move();
        assertThat(car1.getDistance()).isEqualTo(0);
        assertThat(car2.getDistance()).isEqualTo(1);
    }

    @Test
    public void 자동차_전진() {
        Car car1 = new Car(ConstantGenerator.of(9));
        car1.move();
        car1.move();
        assertThat(car1.getDistance()).isEqualTo(2);
    }

    @Test
    public void 자동차_멈춤() {
        Car car1 = new Car(ConstantGenerator.of(0));
        car1.move();
        car1.move();
        assertThat(car1.getDistance()).isEqualTo(0);
    }

    @Test
    public void 각_자동차에_이름을_부여한다() {
        String name = "GV70";
        Car car1 = new Car(name, RandomGenerator.getInstance());
        assertThat(car1.getName()).isEqualTo(name);
    }

    @Test
    public void 이름_5자_초과_불가() {
        String name = "123456";
        assertThrows(NameLengthException.class, () -> {
            new Car(name, RandomGenerator.getInstance());
        });
    }

    @Test
    public void 홀수일_때_전진한다() {
        Car car1 = new Car(ConstantGenerator.of(3), new OddStrategy());
        car1.move();
        assertThat(car1.getDistance()).isEqualTo(1);
    }

    @Test
    public void 짝수일_때_2칸씩_전진한다() {
        Car car1 = new Car(ConstantGenerator.of(2), new EvenStrategy(2));
        car1.move();
        assertThat(car1.getDistance()).isEqualTo(2);
    }
}
