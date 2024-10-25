package racingcar.validator;

import static racingcar.controller.RacingCarController.DELIMITER;

import java.util.List;
import racingcar.exception.CarNameOverLengthLimitException;
import racingcar.exception.EmptyCarNameBetweenCommaException;
import racingcar.exception.SingleCarNameException;
import racingcar.exception.TryCountException;

public class Validator {

    // TODO: static 클래스? 고민해보기

    final static int MIN_TRY_COUNT = 1;
    final static int MAX_TRY_COUNT = 100; // TODO: 수정 가능, 고민해보기

    public static void validateInputCarNamesContainComma(String inputCarNames) {
        if (!inputCarNames.contains(DELIMITER)) {
            throw new SingleCarNameException();
        }
    }

    public static void validateAllCarNames(List<String> splitCarName) {

        validateCarNameOverLengthLimit(splitCarName);
        validateEmptyCarName(splitCarName);
    }

    private static void validateCarNameOverLengthLimit(List<String> splitCarName) {
        splitCarName.stream()
                .filter(carName -> carName.length() > 5)
                .findFirst()
                .ifPresent(carName -> {
                    throw new CarNameOverLengthLimitException();
                });
    }

    private static void validateEmptyCarName(List<String> splitCarName) {
        if (splitCarName.stream().anyMatch(String::isEmpty)) {
            throw new EmptyCarNameBetweenCommaException();
        }
    }

    public static void validateInputCountRange(int inputCount) {

        if (inputCount < MIN_TRY_COUNT || inputCount > MAX_TRY_COUNT) {
            throw new TryCountException();
        }
    }

}
