package racingcar.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.domain.RacingCars;
import racingcar.domain.Winning;

public class RacingCarService {

    RacingCars racingCars;
    Winning winning;

    public RacingCarService() {
        racingCars = new RacingCars();
        winning = new Winning();
    }

    public Map<String, Integer> getNewCars(List<String> splitCarName) {
        return racingCars.initializeCars(splitCarName);
    }

    public void raceOneRound() {
        racingCars.attemptMoveCarsInOneRound();
    }

    public void getWinningScore(Map<String, Integer> cars) {
        winning.findWinningScore(cars);
    }

    public Set<String> getWinningCars(Map<String, Integer> cars) {
        return winning.findWinningCars(cars);
    }
}
