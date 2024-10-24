package racingcar.exception;

public class EmptyNameBetweenCommaException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = "쉼표와 쉼표 사이에 이름을 입력해야 합니다.";
    public EmptyNameBetweenCommaException() {
        super(ERROR_MESSAGE);
    }
}
