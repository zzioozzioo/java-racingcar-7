package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.constants.NumberConstants.MAXIMUM_RANDOM_NUMBER;
import static racingcar.constants.NumberConstants.MINIMUM_RANDOM_NUMBER;
import static racingcar.constants.NumberConstants.MOVE_CONDITION_NUMBER;

public class CarManager {
    public boolean isMoveCondition() {
        return pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER)
                >= MOVE_CONDITION_NUMBER;
    }
}
