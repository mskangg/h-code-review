import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomGenerator;

public class RandomTest {

    @Test
    public void 임의의_0에서_9사이_숫자() {
        RandomGenerator random = RandomGenerator.getInstance();
        assertThat(random.getNumber())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
