package racingcar.io.parser;

import static racingcar.constants.NumberConstants.MAXIMUM_LENGTH_OF_CAR_NAME;
import static racingcar.constants.NumberConstants.MAXIMUM_NUMBER_OF_CARS;
import static racingcar.constants.NumberConstants.MAXIMUM_TRY_COUNT;
import static racingcar.constants.NumberConstants.MINIMUM_TRY_COUNT;
import static racingcar.constants.StringConstants.CAR_NAME_FORMAT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.Delimiter;
import racingcar.exception.InvalidInputException;

public class InputParser {
    public List<String> parseCarNames(String input) {
        validateEmptyInput(input);
        return parseInputCarNames(input);
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException();
        }
    }

    private List<String> parseInputCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(Delimiter.COMMA.getDelimiter()));
        for (String carName : carNames) {
            if (!carName.matches(CAR_NAME_FORMAT)) {
                throw new InvalidInputException();
            }
        }
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        validateNumberOfCars(carNames);
        validateLengthOfCarNames(carNames);
        hasDuplicatedNames(carNames);
    }

    private void validateNumberOfCars(List<String> carNames) {
        if (carNames.size() > MAXIMUM_NUMBER_OF_CARS) {
            throw new InvalidInputException();
        }
    }

    private void validateLengthOfCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAXIMUM_LENGTH_OF_CAR_NAME) {
                throw new InvalidInputException();
            }
        }
    }

    private void hasDuplicatedNames(List<String> carNames) {
        Set<String> noDuplicationCarNames = new HashSet<>(carNames);
        if (carNames.size() != noDuplicationCarNames.size()) {
            throw new InvalidInputException();
        }
    }

    public int parseTryCount(String input) {
        validateEmptyInput(input);
        return parseInputTryCount(input);
    }

    private int parseInputTryCount(String input) {
        int tryCount = isNumeric(input);
        validateTryCount(tryCount);
        return tryCount;
    }

    private int isNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT || tryCount > MAXIMUM_TRY_COUNT) {
            throw new InvalidInputException();
        }
    }
}
