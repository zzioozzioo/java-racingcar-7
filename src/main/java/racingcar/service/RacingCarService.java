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

    public Map<String, Integer> getNewCars(List<String> splitCarNames) {
        return racingCars.initializeCars(splitCarNames);
    }

    public void raceOneRound() {
        racingCars.attemptMoveCarsInOneRound();
    }

    public void getMaxPosition(Map<String, Integer> cars) {
        winning.findMaxPosition(cars);
    }

    public Set<String> getWinningCars(Map<String, Integer> cars) {
        return winning.findWinningCars(cars);
    }
}
