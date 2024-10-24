package racingcar.controller;


import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import racingcar.domain.RacingCars;
import racingcar.domain.Winning;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    // static으로 관리
    public static final String DELIMITER = ",";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Validator validator = new Validator();
    public void run() {

        // 자동차 이름 입력받기
        String inputCarsName = inputView.readCarsName();
        validator.validateInputCarNamesContainComma(inputCarsName);

        // 초기화 전 검증이 가능할까?
        String[] splitCarName = Arrays.stream(inputCarsName.split(DELIMITER, -1))
                .map(String::trim)
                .toArray(String[]::new);
        validator.validateAllCarNames(splitCarName);

        // 시도 횟수 입력받기
        int inputCount = inputView.readTryCount();
        validator.validateInputCountRange(inputCount);

        // 게임 시작
        startRace(splitCarName, inputCount);

    }

    private void startRace(String[] splitCarName, int inputCount) {
        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars = racingCars.initializeCars(splitCarName);

        for (int count = 0; count < inputCount; count++) {
            racingCars.race();
            outputView.printOneRoundResult(cars);
        }

        Winning winning = new Winning();
        winning.calculateWinningScore(cars);
        Set<String> winningCars = winning.getWinningCars(cars);
        outputView.printWinningCars(winningCars);
    }
}
