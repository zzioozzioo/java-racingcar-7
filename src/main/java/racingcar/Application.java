package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.CarNameOverLengthLimitException;
import racingcar.exception.EmptyNameBetweenCommaException;
import racingcar.exception.SingleCarNameException;
import racingcar.exception.TryCountException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final String DELIMITER = ",";
        final int MIN_TRY_COUNT = 1;
        final int MAX_TRY_COUNT = 100; // 수정 가능

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 자동차 이름 입력받기
        String inputCarsName = inputView.readCarsName();

        // validator에 추가
        if (!inputCarsName.contains(DELIMITER)) {
            throw new SingleCarNameException();
        }

        String[] splitCarName = Arrays.stream(inputCarsName.split(DELIMITER, -1))
                .map(String::trim)
                .toArray(String[]::new);

        // validator에 추가
        for (String carName : splitCarName) {
            if (carName.isEmpty()) {
                throw new EmptyNameBetweenCommaException();
            }
        }

        // 시도 횟수 입력받기
        int inputCount = inputView.readTryCount();

        // validator에 추가
        if (inputCount < MIN_TRY_COUNT || inputCount > MAX_TRY_COUNT) {
            throw new TryCountException();
        }

        // 게임 시작
        Map<String, Integer> racingCars = initializeCars(splitCarName);

        for (int count = 0; count < inputCount; count++) {
            race(racingCars);
            outputView.printOneRoundResult(racingCars);
        }

        Set<String> winningCars = getWinningCars(racingCars);
        outputView.printWinningCars(winningCars);

    }

    private static Map<String, Integer> initializeCars(String[] splitCarName) {
        Map<String, Integer> racingCars = new HashMap<>();
        for (String s : splitCarName) {
            validateNameLength(s);
            racingCars.put(s, 0);
        }
        return racingCars;
    }

    // validator에 추가?
    private static void validateNameLength(String s) {
        if (s.length() > 5) {
            throw new CarNameOverLengthLimitException();
        }
    }

    private static void race(Map<String, Integer> racingCars) {
        for (Entry<String, Integer> carEntry : racingCars.entrySet()) {
            if (checkMoveOrNot()) {
                carEntry.setValue(carEntry.getValue() + 1);
            }
        }
    }

    private static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    private static Set<String> getWinningCars(Map<String, Integer> racingCars) {
        int winningScore = Collections.max(racingCars.values());

        return racingCars.entrySet().stream()
                .filter(racingCar -> racingCar.getValue() == winningScore)
                .map(Entry::getKey)
                .collect(Collectors.toSet());

    }
}
