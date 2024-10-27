package racingcar.view;

import static racingcar.util.Delimiter.COMMA;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import racingcar.exception.NonNumericException;

public class InputView {

    public String readCarNames() {
        System.out.println(String.format("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)", COMMA.getDelimiter()));
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputCount;

        try {
            inputCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NonNumericException();
        }

        return inputCount;
    }
}
