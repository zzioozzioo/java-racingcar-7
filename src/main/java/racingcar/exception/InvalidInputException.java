package racingcar.exception;

import static racingcar.constants.ErrorMessages.INVALID_INPUT_ERROR_MESSAGE;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super(INVALID_INPUT_ERROR_MESSAGE);
    }

}
