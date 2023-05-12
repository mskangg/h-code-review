package racingcar.domain;

public interface MoveStrategy {

    int increment();
    boolean canMove(int number);
}
