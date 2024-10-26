package racingcar.util;

import static racingcar.util.Delimiter.COMMA;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.validator.Validator;

public class Utility {

    public static List<String> getSplitCarNames(String inputCarNames) {

        return Arrays.stream(inputCarNames.split(COMMA.getDelimiter(), -1))
                .map(String::trim)
                .peek(Validator::validateAllCarNames)
                .collect(Collectors.toList());
    }

    public static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }
}
