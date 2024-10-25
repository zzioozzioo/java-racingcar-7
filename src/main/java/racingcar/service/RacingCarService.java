package racingcar.service;

import java.util.Map;
import java.util.Set;
import racingcar.domain.RacingCars;
import racingcar.domain.Winning;

public class RacingCarService {

    // TODO: 메서드명 수정

    RacingCars racingCars;
    Winning winning;

    public RacingCarService() {
        racingCars = new RacingCars();
        winning = new Winning();
    }

    public Map<String, Integer> getNewCars(String[] splitCarName) {
        return racingCars.initializeCars(splitCarName);
    }

    public void oneRound() {
        racingCars.raceOneRound();
    }


    public void getWinningScore(Map<String, Integer> cars) {
        winning.calculateWinningScore(cars);
    }

    public Set<String> findWinningCars(Map<String, Integer> cars) {
        return winning.getWinningCars(cars);
    }
}
