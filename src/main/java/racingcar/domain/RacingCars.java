package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.exception.CarNameOverLengthLimitException;

public class RacingCars {

    private final Map<String, Integer> racingCars = new HashMap<>();


    public Map<String, Integer> initializeCars(String[] splitCarName) {
        for (String s : splitCarName) {
            validateNameLength(s);
            racingCars.put(s, 0);
        }
        return racingCars;
    }

    // validator에 추가?
    private void validateNameLength(String s) {
        if (s.length() > 5) {
            throw new CarNameOverLengthLimitException();
        }
    }

    public void race() {
        for (Entry<String, Integer> carEntry : racingCars.entrySet()) {
            if (checkMoveOrNot()) {
                carEntry.setValue(carEntry.getValue() + 1);
            }
        }
    }

    // util함수 -> utility에 포함?
    private boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
