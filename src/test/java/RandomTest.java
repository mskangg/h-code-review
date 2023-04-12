import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.Random;

public class RandomTest {

    @Test
    public void 임의의_0에서_9사이_숫자() {
        Random random = new Random();
        assertThat(random.getNumber())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
