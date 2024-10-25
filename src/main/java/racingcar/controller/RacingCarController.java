package racingcar.controller;

import static racingcar.util.Utility.getSplitCarNames;

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
    Validator validator = new Validator(); // TODO: 객체 생성 or static 고민해보기

    public void run() {

        String inputCarNames = getInputCarNames();
        int inputCount = getInputCount();

        // TODO: 초기화 전 검증이 가능할까?
        String[] splitCarName = getSplitCarNames(inputCarNames);

        race(splitCarName, inputCount);
    }

    private String getInputCarNames() {
        String inputCarNames = inputView.readCarNames();
        validator.validateInputCarNamesContainComma(inputCarNames);
        return inputCarNames;
    }

    private int getInputCount() {
        int inputCount = inputView.readTryCount();
        validator.validateInputCountRange(inputCount);
        return inputCount;
    }


    // TODO: 메서드 분리
    private void race(String[] splitCarName, int inputCount) {
        RacingCars racingCars = new RacingCars();
        Map<String, Integer> cars = racingCars.initializeCars(splitCarName);

        for (int count = 0; count < inputCount; count++) {
            racingCars.raceOneRound();
            outputView.printOneRoundResult(cars);
        }

        Winning winning = new Winning();
        winning.calculateWinningScore(cars);
        Set<String> winningCars = winning.getWinningCars(cars);
        outputView.printWinningCars(winningCars);
    }
}
