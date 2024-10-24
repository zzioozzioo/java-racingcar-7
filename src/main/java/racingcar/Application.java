package racingcar;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final String DELIMITER = ",";
        final int MIN_TRY_COUNT = 1;
        final int MAX_TRY_COUNT = 100; // 수정 가능

        int inputCount = 0;

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

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            inputCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (inputCount < MIN_TRY_COUNT || inputCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상 100 이하여야 합니다.");
        }

        Map<String, Integer> racingCar = new HashMap<>();
        for (String s : splitCarName) {
            validateNameLength(s);
            racingCar.put(s, 0);
        }

        Set<String> winningCars = new HashSet<>();
        for (int count = 0; count < inputCount; count++) {
            for (Entry<String, Integer> carEntry : racingCar.entrySet()) {
                if (checkMoveOrNot()) {
                    carEntry.setValue(carEntry.getValue() + 1);
                }
            }
            winningCars = printGameResult(racingCar);
        }
        printWinningCars(winningCars);

    }

    private static void validateNameLength(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    private static Set<String> printGameResult(Map<String, Integer> racingCar) {
        Set<String> winningCars = new HashSet<>();
        int winningScore = Collections.max(racingCar.values());
        for (Entry<String, Integer> carEntry : racingCar.entrySet()) {
            printOneRoundResult(carEntry);
            if (carEntry.getValue() == winningScore) {
                winningCars.add(carEntry.getKey());
            }
        }
        System.out.println();
        return winningCars;
    }

    private static void printOneRoundResult(Entry<String, Integer> carEntry) {
        String carName = carEntry.getKey();
        Integer nowScore = carEntry.getValue();
        System.out.println(carName + " : " + "-".repeat(nowScore));
    }

    private static void printWinningCars(Set<String> winningCars) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winningCars));
    }
}
