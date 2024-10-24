package racingcar.validator;

import static racingcar.controller.RacingCarController.DELIMITER;

import java.util.Arrays;
import racingcar.exception.CarNameOverLengthLimitException;
import racingcar.exception.EmptyCarNameBetweenCommaException;
import racingcar.exception.SingleCarNameException;
import racingcar.exception.TryCountException;

public class Validator {

    final int MIN_TRY_COUNT = 1;
    final int MAX_TRY_COUNT = 100; // 수정 가능

    //
    public void validateInputCarNamesContainComma(String inputCarsName) {
        if (!inputCarsName.contains(DELIMITER)) {
            throw new SingleCarNameException();
        }
    }

    public void validateAllCarNames(String[] splitCarName) {

        validateCarNameOverLengthLimit(splitCarName);
        validateEmptyCarName(splitCarName);
    }

    private static void validateCarNameOverLengthLimit(String[] splitCarName) {
        Arrays.stream(splitCarName)
                .filter(carName -> carName.length() > 5)
                .findFirst()
                .ifPresent(carName -> {
                    throw new CarNameOverLengthLimitException();
                });
    }

    private static void validateEmptyCarName(String[] splitCarName) {
        if (Arrays.stream(splitCarName).anyMatch(String::isEmpty)) {
                throw new EmptyCarNameBetweenCommaException();
        }
    }

    public void validateInputCountRange(int inputCount) {

        if (inputCount < MIN_TRY_COUNT || inputCount > MAX_TRY_COUNT) {
            throw new TryCountException();
        }
    }

}
