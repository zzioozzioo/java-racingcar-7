package racingcar;

import camp.nextstep.edu.missionutils.*;
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

        int inputCount = 0;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine().trim();

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            inputCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        String[] splitCarName = inputCarName.split(DELIMITER);
        Map<String, Integer> racingCar = new HashMap<>();
        for (String s : splitCarName) {
            racingCar.put(s, 0);
        }

        Set<String> winningCars = new HashSet<>();
        for (int count = 0; count < inputCount; count++) {
            for (Entry<String, Integer> carEntry : racingCar.entrySet()) {
                if (checkMoveOrNot()) {
                    carEntry.setValue(carEntry.getValue() + 1);
                }
            }
            printGameResult(racingCar, winningCars);
        }
        printWinningCars(winningCars);

    }

    private static boolean checkMoveOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    private static void printGameResult(Map<String, Integer> racingCar, Set<String> winningCars) {
        int winningScore = Collections.max(racingCar.values());
        for (Entry<String, Integer> carEntry : racingCar.entrySet()) {
            printOneRoundResult(carEntry);
            if (carEntry.getValue() == winningScore) {
                winningCars.add(carEntry.getKey());
            }
        }
        System.out.println();
    }

    private static void printOneRoundResult(Entry<String, Integer> carEntry) {
        String carName = carEntry.getKey();
        Integer nowScore = carEntry.getValue();
        System.out.println(carName + " : " + "-".repeat(nowScore));
    }

    private static void printWinningCars(Set<String> winningCars) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(",", winningCars));
    }
}
