package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> cars) {
        this.winners = new ArrayList<>();
        int maxDistance = Collections.max(cars).getDistance();
        for (Car car : cars) {
            addWinner(car, maxDistance);
        }
    }

    public List<String> toNames() {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        return names;
    }

    private void addWinner(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            winners.add(car);
        }
    }
}
