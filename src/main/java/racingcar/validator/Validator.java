package racingcar.validator;


import static racingcar.util.Delimiter.COMMA;
import static racingcar.util.TryCount.MAX;
import static racingcar.util.TryCount.MIN;

import racingcar.exception.CarNameOverLengthLimitException;
import racingcar.exception.EmptyCarNameBetweenCommaException;
import racingcar.exception.SingleCarNameException;
import racingcar.exception.TryCountException;

public class Validator {

    private final static int MAX_LENGTH_LIMIT_OF_CAR_NAME = 5;

    public static void validateInputCarNamesContainComma(String inputCarNames) {
        if (!inputCarNames.contains(COMMA.getDelimiter())) {
            throw new SingleCarNameException();
        }
    }

    public static void validateAllCarNames(String carName) {

        validateCarNameOverLengthLimit(carName);
        validateEmptyCarName(carName);
    }

    private static void validateCarNameOverLengthLimit(String carName) {
        if (carName.length() > MAX_LENGTH_LIMIT_OF_CAR_NAME) {
            throw new CarNameOverLengthLimitException();
        }
    }

    private static void validateEmptyCarName(String carName) {
        if (carName.isEmpty()) {
            throw new EmptyCarNameBetweenCommaException();
        }
    }

    public static void validateInputCountRange(int inputCount) {

        if (inputCount < MIN.getTryCount() || inputCount > MAX.getTryCount()) {
            throw new TryCountException();
        }
    }

}
