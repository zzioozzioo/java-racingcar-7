package racingcar.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Winning {

    private int winningScore;

    public void calculateWinningScore(Map<String, Integer> cars) {
        winningScore = Collections.max(cars.values());
    }

    public Set<String> getWinningCars(Map<String, Integer> cars) {

        return cars.entrySet().stream()
                .filter(car -> car.getValue() == winningScore)
                .map(Entry::getKey)
                .collect(Collectors.toSet());

    }
}
