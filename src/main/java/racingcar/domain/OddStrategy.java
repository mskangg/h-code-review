package racingcar.domain;

public class OddStrategy implements MoveStrategy {

    private static final OddStrategy instance = new OddStrategy();

    private OddStrategy() {
    }

    public static MoveStrategy getInstance() {
        return instance;
    }

    @Override
    public boolean canMove(int number) {
        return number % 2 == 1;
    }
}
