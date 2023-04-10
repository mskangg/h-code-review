import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomTest {

    @Test
    public void 임의의_0에서_9사이_숫자() {
        Random random = new Random();
        assertThat(random.getNumber())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }

    @Test
    public void 매번_다른_값() {
        Random random = new Random();
        int num1 = random.getNumber();
        int num2 = random.getNumber();
        int num3 = random.getNumber();
        int num4 = random.getNumber();
        boolean same = (num1 == num2) && (num3 == num4) && (num1 == num3);
        assertThat(same).isFalse();
    }

}
