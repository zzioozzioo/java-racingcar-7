package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.NonNumericException;

public class InputView {

    public String readCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
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
