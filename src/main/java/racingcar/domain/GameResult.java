package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final Map<String, LinkedList<Integer>> roundResults;
    private Winners winners;

    public GameResult() {
        roundResults = new LinkedHashMap<>();
    }

    public void addRound(List<Car> cars) {
        for (Car car : cars) {
            LinkedList<Integer> distanceRecord = roundResults.computeIfAbsent(car.getName(), (k) -> new LinkedList<>());
            distanceRecord.add(car.getDistance());
        }
    }

    public void setWinners(Winners winners) {
        this.winners = winners;
    }

    public Winners getWinners() {
        return winners;
    }

    public Map<String, LinkedList<Integer>> getRoundResults() {
        return Collections.unmodifiableMap(roundResults);
    }
}
