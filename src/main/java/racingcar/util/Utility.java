package racingcar.util;

import static racingcar.controller.RacingCarController.DELIMITER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import racingcar.validator.Validator;

public class Utility {

    public static String[] getSplitCarNames(String inputCarNames) {
        String[] splitCarName = Arrays.stream(inputCarNames.split(DELIMITER, -1))
                .map(String::trim)
                .toArray(String[]::new);

        Validator.validateAllCarNames(splitCarName);
        return splitCarName;
    }

    public static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
