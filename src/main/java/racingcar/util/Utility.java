package racingcar.util;

import static racingcar.controller.RacingCarController.DELIMITER;
import static racingcar.validator.Validator.validateAllCarNames;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    public static List<String> getSplitCarNames(String inputCarNames) {
        List<String> splitCarName = Arrays.stream(inputCarNames.split(DELIMITER, -1))
                .map(String::trim)
                .collect(Collectors.toList());

        validateAllCarNames(splitCarName);
        return splitCarName;
    }

    public static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
