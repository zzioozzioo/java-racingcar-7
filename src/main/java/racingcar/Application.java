package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final String DELIMITER = ",";
        final int MIN_TRY_COUNT = 1;
        final int MAX_TRY_COUNT = 100; // 수정 가능

        int inputCount = 0;

        // 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        if (!inputCarName.contains(DELIMITER)) {
            throw new IllegalArgumentException("자동차의 이름은 두 개 이상 입력해야 합니다.");
        }

        String[] splitCarName = Arrays.stream(inputCarName.split(DELIMITER, -1))
                .map(String::trim)
                .toArray(String[]::new);

        for (String carName : splitCarName) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("쉼표와 쉼표 사이에 이름을 입력해야 합니다.");
            }
        }

        // 시도 횟수 입력받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            inputCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (inputCount < MIN_TRY_COUNT || inputCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상 100 이하여야 합니다.");
        }

        // 게임 시작
        Map<String, Integer> racingCars = initializeCars(splitCarName);

        for (int count = 0; count < inputCount; count++) {
            race(racingCars);
            printOneRoundResult(racingCars);
        }

        Set<String> winningCars = getWinningCars(racingCars);
        printWinningCars(winningCars);

    }

    private static Map<String, Integer> initializeCars(String[] splitCarName) {
        Map<String, Integer> racingCars = new HashMap<>();
        for (String s : splitCarName) {
            validateNameLength(s);
            racingCars.put(s, 0);
        }
        return racingCars;
    }

    private static void validateNameLength(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
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

    private static void printOneRoundResult(Map<String, Integer> racingCar) {
        for (Entry<String, Integer> carEntry : racingCar.entrySet()) {
            printOneCarResult(carEntry);
        }
        System.out.println();
    }

    private static void printOneCarResult(Entry<String, Integer> carEntry) {
        String carName = carEntry.getKey();
        Integer nowScore = carEntry.getValue();
        System.out.println(carName + " : " + "-".repeat(nowScore));
    }

    private static Set<String> getWinningCars(Map<String, Integer> racingCars) {
        int winningScore = Collections.max(racingCars.values());

        return racingCars.entrySet().stream()
                .filter(racingCar -> racingCar.getValue() == winningScore)
                .map(Entry::getKey)
                .collect(Collectors.toSet());

    }

    private static void printWinningCars(Set<String> winningCars) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winningCars));
    }
}
