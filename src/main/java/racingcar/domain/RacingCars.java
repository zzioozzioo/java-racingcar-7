package racingcar.domain;

import static racingcar.util.Utility.checkMoveOrNot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {

    private final Map<String, Integer> racingCars = new HashMap<>();


    public Map<String, Integer> initializeCars(List<String> splitCarName) {

        splitCarName.forEach(carName -> racingCars.put(carName, 0));

        return racingCars;
    }

    public void attemptMoveCarsInOneRound() {

        racingCars.entrySet().forEach(carEntry -> {
            if (checkMoveOrNot()) {
                carEntry.setValue(carEntry.getValue() + 1);
            }
        });
    }

}
