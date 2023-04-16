import java.util.Random;

public interface RandomUtil {
    int generate(int bound);
}

class DefaultRandomUtil implements RandomUtil {

    private static final Random RANDOM = new Random();

    @Override
    public int generate(int bound) {
        return RANDOM.nextInt(bound + 1);
    }
}