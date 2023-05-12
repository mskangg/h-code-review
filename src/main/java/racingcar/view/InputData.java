package racingcar.view;

import java.util.List;
import racingcar.domain.RacingGame;

public class InputData {

    private final int moveCount;
    private final List<String> names;

    public InputData(int moveCount, List<String> names) {
        this.moveCount = moveCount;
        this.names = names;
    }

    public RacingGame toRacingGame() {
        return RacingGame.withRandomMoving(moveCount, names);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public List<String> getNames() {
        return names;
    }
}
