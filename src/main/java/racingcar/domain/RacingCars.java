package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RacingCars {

    private final Map<String, Integer> racingCars = new HashMap<>();


    public Map<String, Integer> initializeCars(String[] splitCarName) {

        Arrays.stream(splitCarName)
                .forEach(carName -> racingCars.put(carName, 0));

        return racingCars;
    }


    public void raceOneRound() {

        racingCars.entrySet().forEach(carEntry -> {
            if (checkMoveOrNot()) {
                carEntry.setValue(carEntry.getValue() + 1);
            }
        });
    }

    // util함수 -> utility에 포함?
    private boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
