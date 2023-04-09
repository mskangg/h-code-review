import java.util.Random;

public class CarMovementCalculator {

    private static final Random random = new Random(9);

    private CarMovementCalculator() {
    }

    public static boolean isCarMovement() {
        return random.nextInt() > 4;
    }

}
