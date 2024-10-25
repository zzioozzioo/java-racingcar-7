package racingcar.controller;

import static racingcar.util.Utility.getSplitCarNames;
import static racingcar.validator.Validator.validateInputCarNamesContainComma;
import static racingcar.validator.Validator.validateInputCountRange;

import java.util.Map;
import java.util.Set;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    // TODO: enum 타입으로 관리 고려해보기
    public static final String DELIMITER = ",";

    RacingCarService service = new RacingCarService();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {

        String inputCarNames = getInputCarNames();
        int inputCount = getInputCount();

        // TODO: 초기화 전 검증이 가능할까?
        String[] splitCarName = getSplitCarNames(inputCarNames);

        race(splitCarName, inputCount);

    }

    private String getInputCarNames() {
        String inputCarNames = inputView.readCarNames();
        validateInputCarNamesContainComma(inputCarNames);
        return inputCarNames;
    }

    private int getInputCount() {
        int inputCount = inputView.readTryCount();
        validateInputCountRange(inputCount);
        return inputCount;
    }


    // TODO: 메서드 분리
    private void race(String[] splitCarName, int inputCount) {
        Map<String, Integer> cars = service.getNewCars(splitCarName);
        raceAllRound(inputCount, cars);
        printWinners(cars);
    }

    private void raceAllRound(int inputCount, Map<String, Integer> cars) {
        for (int count = 0; count < inputCount; count++) {
            service.raceOneRound();
            outputView.printOneRoundResult(cars);
        }
    }

    private void printWinners(Map<String, Integer> cars) {
        service.getWinningScore(cars);
        Set<String> winningCars = service.getWinningCars(cars);
        outputView.printWinningCars(winningCars);
    }
}
