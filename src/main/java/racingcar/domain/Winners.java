package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> cars) {
        this.winners = new ArrayList<>();
        Car maxCar = Collections.max(cars);
        for (Car car : cars) {
            addWinner(car, maxCar);
        }
    }

    public List<String> toNames() {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        return names;
    }

    private void addWinner(Car car, Car maxCar) {
        if (car.isMax(maxCar)) {
            winners.add(car);
        }
    }
}
