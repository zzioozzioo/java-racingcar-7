package racingcar.exception;

public class TryCountException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "시도할 횟수는 1 이상 100 이하여야 합니다.";
    public TryCountException() {
        super(ERROR_MESSAGE);
    }
}
